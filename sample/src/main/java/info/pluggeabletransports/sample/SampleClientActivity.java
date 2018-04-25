package info.pluggeabletransports.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

import info.pluggabletransports.dispatch.Connection;
import info.pluggabletransports.dispatch.DispatchConstants;
import info.pluggabletransports.dispatch.Dispatcher;
import info.pluggabletransports.dispatch.Transport;
import info.pluggabletransports.dispatch.transports.MeekTransport;

public class SampleClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_client);

        Properties options = new Properties();
        String bridgeAddress = "https://meek.actualdomain.com";

        options.put(MeekTransport.OPTION_FRONT,"www.somefrontabledomain.com");
        options.put(MeekTransport.OPTION_KEY,"18800CFE9F483596DDA6264C4D7DF7331E1E39CE");

        init(DispatchConstants.PT_TRANSPORTS_MEEK, bridgeAddress, options);

    }

    public void init (String type, String bridgeAddress, Properties options)
    {
        Transport transport = Dispatcher.get().getTransport(type, options);

        if (transport != null)
        {
            Connection conn = transport.connect(bridgeAddress);

            //now use the connection, either as a proxy, or to read and write bytes directly

        }
    }
}
