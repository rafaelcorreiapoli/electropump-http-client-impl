public class HttpClientAPI: NSObject  {

    static let kRequestFetch = "com.HttpClientApi.ern.api.request.fetch";


    public lazy var requests: HttpClientAPIRequests = {
        return HttpClientRequests()
    }()
}


public class HttpClientAPIRequests: NSObject {
    public func registerFetchRequestHandler(handler: @escaping ElectrodeBridgeRequestCompletionHandler) {
        assertionFailure("should override")
    }

    public func fetch(fetchData: FetchData, responseCompletionHandler: @escaping ElectrodeBridgeResponseCompletionHandler) {
        assertionFailure("should override")
    }

}

