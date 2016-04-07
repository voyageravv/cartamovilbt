# Bluetooth Plugin

Install with Cordova cli

$ cordova plugin add https://github.com/voyageravv/cartamovilbt


API
Methods

connect

Connect to a Bluetooth device.

bt.connect(macAddress_or_uuid, connectSuccess, connectFailure);
Description

Function connect connects to a Bluetooth device. The callback is long running. Success will be called when the connection is successful. Failure is called if the connection fails, or later if the connection disconnects. An error message is passed to the failure callback.

Android

For Android, connect takes a MAC address of the remote device.

disconnect

Disconnect.

bt.disconnect([success], [failure]);
Description

Function disconnect disconnects the current connection.

Parameters

success: Success callback function that is invoked when the connection is successful. [optional]
failure: Error callback function, invoked when error occurs. [optional]
write

Writes data to the serial port.

bt.write(data, success, failure);
Description

Function write data to the serial port. Data can be an ArrayBuffer, string, array of integers, or a Uint8Array.

Internally string, integer array, and Uint8Array are converted to an ArrayBuffer. String conversion assume 8bit characters.

Parameters

data: ArrayBuffer of data
success: Success callback function that is invoked when the connection is successful. [optional]
failure: Error callback function, invoked when error occurs. [optional]


Quick Example

// string
bt.write("hello, world", success, failure);


list

Lists bonded devices (only accesible) 

bt.list(success, failure);
Description

Android

Function list lists the paired Bluetooth devices. The success callback is called with a list of objects.

Example list passed to success callback. See BluetoothDevice and BluetoothClass#getDeviceClass.

[{
    "id": "10:BF:48:CB:00:00",
    "isConnected": true,
 
}, {
    "id": "00:06:66:4D:00:00",
    "isConnected": false,
}]

Parameters

success: Success callback function that is invoked with a list of bonded devices.
failure: Error callback function, invoked when error occurs. [optional]
Quick Example

bt.list(function(devices) {
    devices.forEach(function(device) {
        console.log(device.id);
    })
}, failure);

