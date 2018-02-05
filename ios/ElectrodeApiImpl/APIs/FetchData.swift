
public class FetchData: ElectrodeObject, Bridgeable {

    private static let tag = String(describing: type(of: self))

    public let url: String
    public let method: String
    public let data: String?
    public let headers: String?

    public init(url: String, method: String, data: String, headers: String) {
        self.url = url
        self.method = method
        self.data = data
        self.headers = headers
        super.init()
    }

    public override init() {
        self.url = String()
        self.method = String()
        self.data = nil
        self.headers = nil
        super.init()
    }

    required public init(dictionary:[AnyHashable:Any]) {
        if

                let url = dictionary["url"] as? String,

                let method = dictionary["method"] as? String { 
            self.url = url
            self.method = method
        } else {
            assertionFailure("\(FetchData.tag) missing one or more required properties[url,method]")
            self.url = dictionary["url"] as! String
            self.method = dictionary["method"] as! String
        }

        self.data = dictionary["data"] as? String
        self.headers = dictionary["headers"] as? String

        super.init(dictionary: dictionary)
    }

    public func toDictionary() -> NSDictionary {
        var dict =  [
            "url": self.url,
            "method": self.method
        ] as [AnyHashable : Any]

        if let nonNulldata = self.data {
            dict["data"] = nonNulldata
        }
        if let nonNullheaders = self.headers {
            dict["headers"] = nonNullheaders
        }
        return dict as NSDictionary
    }

}
