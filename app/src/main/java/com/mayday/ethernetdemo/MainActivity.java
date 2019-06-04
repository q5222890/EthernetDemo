package com.mayday.ethernetdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.open)
    Button open;
    @BindView(R.id.close)
    Button close;
    @BindView(R.id.dhcp_button)
    Button dhcpButton;
    @BindView(R.id.static_button)
    Button staticButton;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    @BindView(R.id.static_ip)
    EditText staticIp;
    @BindView(R.id.static_netmask)
    EditText staticNetmask;
    @BindView(R.id.static_dns1)
    EditText staticDns1;
    @BindView(R.id.static_dns2)
    EditText staticDns2;
    @BindView(R.id.static_gateway)
    EditText staticGateway;
    //    private Button open, close, dhcp_button, static_button;
    private EthernetMain ethernetMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        open= (Button) findViewById(R.id.open);
//        close= (Button) findViewById(R.id.close);
//        dhcp_button= (Button) findViewById(R.id.dhcp_button);
//        static_button= (Button) findViewById(R.id.static_button);

        ethernetMain = new EthernetMain(this);
        String staticIP = ethernetMain.getStaticIP();
        String gateway = ethernetMain.getGateway();
        String netMask = ethernetMain.getNetMask();
        String dns1 = ethernetMain.getDNS1();
        String dns2 = ethernetMain.getDNS2();
        staticIp.setText(staticIP);
        staticGateway.setText(gateway);
        staticNetmask.setText(netMask);
        staticDns1.setText(dns1);
        staticDns2.setText(dns2);
//        open.setOnClickListener(this);
//        close.setOnClickListener(this);
//        dhcp_button.setOnClickListener(this);
//        static_button.setOnClickListener(this);
    }

//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.open:
//                ethernetMain.openEth();
//                break;
//
//            case R.id.close:
//                ethernetMain.closeEth();
//                break;
//
//            case R.id.dhcp_button:
//                ethernetMain.dhcpEth();
//                break;
//
//            case R.id.static_button:
//                ethernetMain.staticEth("192.168.1.222", "255.255.255.0", "192.168.1.1", "192.168.1.1", "192.168.1.1");
//                break;
//        }
//    }

    @OnClick({R.id.open, R.id.close, R.id.dhcp_button, R.id.static_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.open:
                ethernetMain.openEth();
                break;
            case R.id.close:
                ethernetMain.closeEth();
                break;
            case R.id.dhcp_button:
                ethernetMain.dhcpEth();
                break;
            case R.id.static_button:
                String IP = staticIp.getText().toString().trim();
                String netmask = staticNetmask.getText().toString().trim();
                String gateway = staticGateway.getText().toString().trim();
                String dns1 = staticDns1.getText().toString().trim();
                String dns2 = staticDns2.getText().toString().trim();
                ethernetMain.staticEth(IP, netmask, dns1, dns2, gateway);
                break;
        }
    }
}
