var socket = $.atmosphere;

function handleAtmosphere( transport ) {
    var asyncHttpStatistics = {
        transportType: 'N/A',
        responseState: 'N/A',
        numberOfCallbackInvocations: 0,
        numberOfTweets: 0,
        numberOfErrors: 0
    };
    
    var request = new $.atmosphere.AtmosphereRequest();
    request.transport = transport;
    request.url = "async";
    request.contentType = "text/html";
    request.fallbackTransport = null;
    
    request.onMessage = function(response){
        $.atmosphere.log('info', ["response.state: " + response.state]);
        $.atmosphere.log('info', ["response.transport: " + response.transport]);
        $.atmosphere.log('info', ["response.responseBody: " + response.responseBody]);
        $('.messageContainer').html(response.responseBody);
        console.log(response);
    };

    request.onMessagePublished = function(response){

    };

    request.onOpen = function() { $.atmosphere.log('info', ['socket open']); };
    request.onError =  function() { $.atmosphere.log('info', ['socket error']); };
    request.onReconnect =  function() { $.atmosphere.log('info', ['socket reconnect']); };

    var subSocket = socket.subscribe(request);
}

handleAtmosphere("streaming");