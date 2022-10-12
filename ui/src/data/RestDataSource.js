import Axios from "axios";
import { RestUrls } from "./Urls";

export class RestDataSource {

    GetData = (dataType) => this.SendRequest("get", RestUrls[dataType]);

    SendRequest = (method, url, params) => {
        console.log('=> Calling : ' + url);
        return Axios.request({method, url, params});
    }
}