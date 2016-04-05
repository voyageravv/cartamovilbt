/*global cordova, module*/

module.exports = {
    write: function (mensaje, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "Bt", "write", [mensaje]);
    },
    connect: function (MAC, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "Bt", "connect", [MAC]);
    },
    list: function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "Bt", "list", []);
    },
    disconnect: function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "Bt", "disconnect", []);
    }
   
};
