
public class HttpClientRequests: HttpClientAPIRequests {

    public override func registerFetchRequestHandler(handler:  @escaping ElectrodeBridgeRequestCompletionHandler) {
        let requestHandlerProcessor = ElectrodeRequestHandlerProcessor(requestName: HttpClientAPI.kRequestFetch,
    reqClass: FetchData.self, 
    respClass: Response.self,
    requestCompletionHandler: handler)
        requestHandlerProcessor.execute()
    }

    //------------------------------------------------------------------------------------------------------------------------------------


    public override func fetch(fetchData: FetchData, responseCompletionHandler: @escaping ElectrodeBridgeResponseCompletionHandler) {
        let requestProcessor = ElectrodeRequestProcessor<FetchData, Response, Any>(
            requestName: HttpClientAPI.kRequestFetch,
            requestPayload: fetchData,
            respClass: Response.self,
            responseItemType: nil,
            responseCompletionHandler: responseCompletionHandler)

        requestProcessor.execute()
    }
}