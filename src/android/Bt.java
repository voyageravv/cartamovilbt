package com.cartamovil.plugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Set;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.RT_Printer.BluetoothPrinter.BLUETOOTH.BluetoothPrintDriver;
public class Bt extends CordovaPlugin {
 private JSONObject deviceToJSON(BluetoothDevice device) throws JSONException {
        JSONObject json = new JSONObject();
        if (BluetoothPrintDriver.OpenPrinter(device.getAddress()))
        {
	  json.put("id", device.getAddress());
	  BluetoothPrintDriver.close();
	}        
        return json;
    }
private BluetoothAdapter bluetoothAdapter;
    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
 if (action.equals("connect")){
	    String MAC = data.getString(0);
	    if(!BluetoothPrintDriver.OpenPrinter(MAC)) 	
	            	{
	            		BluetoothPrintDriver.close();
	                	callbackContext.success("KO");
	            	}
	            	else
	            	{
			  callbackContext.success("OK");
			  
	            	}
             return true;
        }else
        if (action.equals("write")) {

           String mensaje = data.getString(0);
	    

	            	
			 BluetoothPrintDriver.Begin();
			 BluetoothPrintDriver.ImportData(mensaje );
			  BluetoothPrintDriver.excute();
			BluetoothPrintDriver.ClearData();
			  callbackContext.success(1);
			  
	    
            return true;

        }
        else
        if (action.equals("disconnect")) {

          
			BluetoothPrintDriver.ClearData();
			BluetoothPrintDriver.close();
			  callbackContext.success(1);
			  
	    
            return true;

        }
        else
        if (action.equals("list")) {
	    if (bluetoothAdapter == null) {
	      bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
	    }	  
	    JSONArray deviceList = new JSONArray();
	    Set<BluetoothDevice> bondedDevices = bluetoothAdapter.getBondedDevices();

	    for (BluetoothDevice device : bondedDevices) {
		deviceList.put(deviceToJSON(device));
        }
        callbackContext.success(deviceList);
            return true;

        }
         else {
            
            return false;

        }
    }
}
