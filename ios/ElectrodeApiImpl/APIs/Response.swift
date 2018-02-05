public class Response: ElectrodeObject, Bridgeable {

    private static let tag = String(describing: type(of: self))

    public let body: String?
    public let headers: String?
    public let status: Int?

    public init(body: String?, headers: String?, status: Int?) {
        self.body = body
        self.headers = headers
        self.status = status
        super.init()
    }

    public override init() {
        self.body = nil
        self.headers = nil
        self.status = nil
        super.init()
    }

    required public init(dictionary:[AnyHashable:Any]) {



        if let body = dictionary["body"] as? String {
            self.body = body
        } else {
            self.body = nil
        }
        

        if let headers = dictionary["headers"] as? String {
            self.headers = headers
        } else {
            self.headers = nil
        }
        

        if let status = dictionary["status"] as? Int {
            self.status = status
        } else {
            self.status = nil
        }
        
        super.init(dictionary: dictionary)
    }

    public func toDictionary() -> NSDictionary {

         var dict = [:] as [AnyHashable : Any]

         
        if let nonNullBody = self.body {
                dict["body"] = nonNullBody
        }
        if let nonNullHeaders = self.headers {
                dict["headers"] = nonNullHeaders
        }
        if let nonNullStatus = self.status {
                dict["status"] = nonNullStatus
        }
        return dict as NSDictionary
    }
}
