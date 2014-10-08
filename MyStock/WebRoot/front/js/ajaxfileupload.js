
jq.extend({
	

    createUploadIframe: function(id, uri)
	{
			//create frame
            var frameId = 'jUploadFrame' + id;
            var iframeHtml = '<iframe id="' + frameId + '" name="' + frameId + '" style="position:absolute; top:-9999px; left:-9999px"';
			if(window.ActiveXObject)
			{
                if(typeof uri== 'boolean'){
					iframeHtml += ' src="' + 'javascript:false' + '"';

                }
                else if(typeof uri== 'string'){
					iframeHtml += ' src="' + uri + '"';

                }	
			}
			iframeHtml += ' />';
			jq(iframeHtml).appendTo(document.body);

            return jq('#' + frameId).get(0);			
    },
    createUploadForm: function(id, fileElementId)
	{
		//create form	
		var formId = 'jUploadForm' + id;
		var fileId = 'jUploadFile' + id;
		var form = jq('<form  action="" method="POST" name="' + formId + '" id="' + formId + '" enctype="multipart/form-data"></form>');	
		var oldElement = jq('#' + fileElementId);
		var newElement = jq(oldElement).clone();
		jq(oldElement).attr('id', fileId);
		jq(oldElement).before(newElement);
		jq(oldElement).appendTo(form);
		//set attributes
		jq(form).css('position', 'absolute');
		jq(form).css('top', '-1200px');
		jq(form).css('left', '-1200px');
		jq(form).appendTo('body');		
		return form;
    },

    ajaxFileUpload: function(s) {
        // TODO introduce global settings, allowing the client to modify them for all requests, not only timeout		
        s = jq.extend({}, jq.ajaxSettings, s);
        var id = new Date().getTime()        
		var form = jq.createUploadForm(id, s.fileElementId);
		var io = jq.createUploadIframe(id, s.secureuri);
		var frameId = 'jUploadFrame' + id;
		var formId = 'jUploadForm' + id;		
        // Watch for a new set of requests
        if ( s.global && ! jq.active++ )
		{
			jq.event.trigger( "ajaxStart" );
		}            
        var requestDone = false;
        // Create the request object
        var xml = {}   
        if ( s.global )
            jq.event.trigger("ajaxSend", [xml, s]);
        // Wait for a response to come back
        var uploadCallback = function(isTimeout)
		{			
			var io = document.getElementById(frameId);
            try 
			{				
				if(io.contentWindow)
				{
					 xml.responseText = io.contentWindow.document.body?io.contentWindow.document.body.innerHTML:null;
                	 xml.responseXML = io.contentWindow.document.XMLDocument?io.contentWindow.document.XMLDocument:io.contentWindow.document;
					 
				}else if(io.contentDocument)
				{
					 xml.responseText = io.contentDocument.document.body?io.contentDocument.document.body.innerHTML:null;
                	xml.responseXML = io.contentDocument.document.XMLDocument?io.contentDocument.document.XMLDocument:io.contentDocument.document;
				}						
            }catch(e)
			{
				jq.handleError(s, xml, null, e);
			}
            if ( xml || isTimeout == "timeout") 
			{				
                requestDone = true;
                var status;
                try {
                    status = isTimeout != "timeout" ? "success" : "error";
                    // Make sure that the request was successful or notmodified
                    if ( status != "error" )
					{
                        // process the data (runs the xml through httpData regardless of callback)
                        var data = jq.uploadHttpData( xml, s.dataType );    
                        // If a local callback was specified, fire it and pass it the data
                        if ( s.success )
                            s.success( data, status );
    
                        // Fire the global callback
                        if( s.global )
                            jq.event.trigger( "ajaxSuccess", [xml, s] );
                    } else
                        jq.handleError(s, xml, status);
                } catch(e) 
				{
                    status = "error";
                    jq.handleError(s, xml, status, e);
                }

                // The request was completed
                if( s.global )
                    jq.event.trigger( "ajaxComplete", [xml, s] );

                // Handle the global AJAX counter
                if ( s.global && ! --jq.active )
                    jq.event.trigger( "ajaxStop" );

                // Process result
                if ( s.complete )
                    s.complete(xml, status);

                jq(io).unbind()

                setTimeout(function()
									{	try 
										{
											jq(io).remove();
											jq(form).remove();	
											
										} catch(e) 
										{
											jq.handleError(s, xml, null, e);
										}									

									}, 100)

                xml = null

            }
        }
        // Timeout checker
        if ( s.timeout > 0 ) 
		{
            setTimeout(function(){
                // Check to see if the request is still happening
                if( !requestDone ) uploadCallback( "timeout" );
            }, s.timeout);
        }
        try 
		{

			var form = jq('#' + formId);
			jq(form).attr('action', s.url);
			jq(form).attr('method', 'POST');
			jq(form).attr('target', frameId);
            if(form.encoding)
			{
				jq(form).attr('encoding', 'multipart/form-data');      			
            }
            else
			{	
				jq(form).attr('enctype', 'multipart/form-data');			
            }			
            jq(form).submit();

        } catch(e) 
		{			
            jq.handleError(s, xml, null, e);
        }
		
		jq('#' + frameId).load(uploadCallback	);
        return {abort: function () {}};	

    },

    uploadHttpData: function( r, type ) {
        var data = !type;
        data = type == "xml" || data ? r.responseXML : r.responseText;
        // If the type is "script", eval it in global context
        if ( type == "script" )
            jq.globalEval( data );
        // Get the JavaScript object, if JSON is used.
        if ( type == "json" )
            eval( "data = " + data );
        // evaluate scripts within html
        if ( type == "html" )
            jq("<div>").html(data).evalScripts();

        return data;
    }
})

