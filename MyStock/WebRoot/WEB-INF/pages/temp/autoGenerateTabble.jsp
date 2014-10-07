<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Insert title here</title>
<style type="text/css">
#autoGen td{
	font-size:16px;
	color:black;
	width:100px;height: 30px;
	border: 1px solid black;
}
#autoGen tr:nth-child(1){
	background: gray;
}
#autoGen tr td:first-of-type{
	background: gray;
}
</style>
</head>
<body>
<h3>表格编辑</h3>

<label>行数：</label><input type="text" name="row"/>
<label>列数：</label><input type="text" name="col" />
<input type="button" value="生成表格" id="generate" >
<input type="button" value="清除表格" id="clear">
<input type="button" value="增加一行" id="addrow">
<input type="button" value="增加一列" id="addcol">
<table id="autoGen" cellspacing="0" style="borde:1px solid black;"></table>
<input type="button" value="排序" id="sort">
</body>
<script type="text/javascript" src="front/js/jquery.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var col,row;	
	$("#generate").on({
		click:function(){
			var rowt=parseInt($("input[name='row']").val()),
			colt=parseInt($("input[name='col']").val());	
			row=rowt;col=colt;
			generateTable(rowt, colt);				
			//可编辑table
			
			//增加最上和最左边的列
			addBorder();
			//选中一列
			selectCol("#autoGen td");
			var numTd = $("#autoGen td");
			numTd.on({
				click:function(){
					editTable("autoGen");
				}//end
			});
		}
	});
	
	//增加一行
	$("#addrow").on({
		click:function(){	
			var tdnum=parseInt($("#autoGen td").length);
			col=parseInt($("#autoGen tr").length);	
			col=tdnum/col;
			var td="<td></td>";
			for(var i=0;i<col-1;i++){
				td+="<td></td>";
			}
			var tr="<tr>"+td+"</tr>";
			$("#autoGen").append(tr);
			var numTd = $("#autoGen td");
			numTd.on({
				click:function(){
					editTable("autoGen");
				}
			})
			row+=1;
		}
	})
	
	//增加一列
	$("#addcol").on({
		click:function(){						
			var tr=$("#autoGen tr");
			var td="<td></td>";
			tr.each(function(){
				$(this).append(td);
			})
			//可编辑table
			var numTd = $("#autoGen td");
			numTd.on({
				click:function(){
					editTable("autoGen");
				}//end
			})
			col+=1;
		}
	})
	
	//增加边框
	function addBorder(){
		//增加最上行
		var tdnum=parseInt($("#autoGen td").length);
		col=parseInt($("#autoGen tr").length);	
		col=tdnum/col;
		var td="<td data-td='top'></td>";
		for(var i=0;i<col-1;i++){
			td+="<td data-td='top'></td>";
		}
		var tr="<tr style='background:gray;'>"+td+"</tr>";
		$("#autoGen").prepend(tr);
		var numTd = $("#autoGen td");
		numTd.on({
			click:function(){
				editTable("autoGen");
			}
		})
		//row+=1;
		//增加最左列
		var tr=$("#autoGen tr");
		var td="<td style='background:gray;'></td>";
		tr.each(function(){
			$(this).prepend(td);
		})
		//可编辑table
		var numTd = $("#autoGen td");
		numTd.on({
			click:function(){
				editTable("autoGen");
			}//end
		})
		//col+=1;
	}
	
	//指定行和列生成表格
	function generateTable(row,col){
		var i,td="<td></td>",tr=[],trt='';
		for(i=0;i<col-1;i++){
			td+="<td></td>";
		}
		for(i=0;i<row;i++){
			tr[i]="<tr>"+td+"</tr>";
		}
		for(i=0;i<row;i++){
			trt+=tr[i];
		}
		$("table[id='autoGen']").append(trt);	
	}
	
	//可编辑表格
	function editTable(tableId){
		var str="#"+tableId+" td:nth-child()";
		var editTd=$(str); 
		editTd.on({
			click:function(){
				var currentTd=$(this);
				if (currentTd.children("input").length > 0) { 
			         //如果当前td中已包含有文本框元素，则不执行click事件 
			         return false; 
			    }
				var tdtext = currentTd.html();
				currentTd.html("");
				var inputOjb = $("<input type='text' />").css("border-width", "0")
                				.css("background-color", currentTd.css("background-color")).css("width","100px")
                				.val(tdtext).appendTo(currentTd); 
				inputOjb.click(function() {
					return false;
				}); 
				inputOjb.trigger("focus").trigger("select");
				inputOjb.keyup(function(){
					var keyCode = event.which;
					if (keyCode == 13){
						var inputText=$(this).val();
						currentTd.html(inputText);
					}
					if (keyCode == 27){
						currentTd.html(tdtext);
					}
				})
			}
		})
	}
	
	//删除表格
	$("#clear").on({
		click:function(){
			$("tr").remove();
		}
	})
	
	
	//快速排序
	function quickSort(array,left,right){
		if(left>=right){
			return;
		}else{
			var i=left,j=right,/*flag=array[left].arr("indexFlag"),*/flagObj=array[left];
			alert(flagObj);
			while(i<j){
				if (array[j].arr("indexFlag")>flag){
					j--;
				}else if(array[j].arr("indexFlag")<flag){
					array[i].before(array[j]);
					array[j]=flagObj;
					//arr[i]=arr[j];
					//arr[j]=flag;
					i++;
				}else if(array[i]>flag){
					//arr[j]=arr[i];
					//arr[i]=flag;
					array[j].after(array[i]);
					array[i]=flagObj;
					j--;
				}else{
					i++;
				}
			}
			quickSort(array, left, i-1);
			quickSort(array, i+1, right);
			return array;
		}
	}
	
	$.fn.quickSort = function(left,right){
		if(left>=right){
			return;
		}else{
			var i=left,j=right,flag=$(this[left]).attr("indexFlag");		
			while(i<j){
				alert(flag);
				/*if (this[j]>flag){
					j--;
				}else if(this[j]<flag){
					this[i]=this[j];
					this[j]=flag;
					i++;
				}else if(this[i]>flag){
					this[j]=this[i];
					this[i]=flag;
					j--;
				}else{
					i++;
				}*/
			}
			this.quickSort(left, i-1);
			this.quickSort(i+1, right);
		}
	};
	
	$("#sort").on({
		click:function(){
			var table=$("#autoGen tr"),i,j;
			table.each(function(){
				//table_flag[$(this).index()]=$(this).children(":first").children().val();
				$(this).attr("indexFlag",parseInt($(this).children(":first").children().val()));
				//alert(typeof $(this).attr("indexFlag"));
			});
			for(i=0;i<table.length;i++){
				for(j=i;j<table.length;j++){
					//排序 -- 从大到小
					//alert("sort in i ="+i+"  j = "+j);
					if(parseInt($(table[j]).attr("indexFlag"))>parseInt($(table[i]).attr("indexFlag"))){
						//alert("change");
						var tmpObj=table[j];
						$(table[i]).before(tmpObj);
					}else{
						//alert("not");
					}
				}
			}
		}
	});
	
	//选中一列
	function selectCol(tdSet){
		alert(tdSet.length);
		/*tdSet.on({
			click:function(){
				alert($(this).index());
			}
		})*/
	}
})
</script>
</html>