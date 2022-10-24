import Axios from "axios";
import { RestUrls } from "./Urls";

export class RestDataSource {

    GetData = async(dataType, params) =>
        this.SendRequest("get", RestUrls[dataType], params);

    SendRequest = (method, url, params) => {
        console.log('=> Calling : ' + url);
        return Axios.request({method, url, params});
    }
}