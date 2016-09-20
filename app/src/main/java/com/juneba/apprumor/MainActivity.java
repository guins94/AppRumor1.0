package com.juneba.apprumor;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.IdRes;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragCardapio fragCardapio = new FragCardapio();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.contentContainer,fragCardapio).commit();

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if(tabId == R.id.tab_favorites){
                    FragCardapio fragCard = new FragCardapio();
                    FragmentManager fragManCard =getFragmentManager();
                    FragmentTransaction fragTransCard = fragManCard.beginTransaction();
                    fragTransCard.replace(R.id.contentContainer,fragCard);
                    fragTransCard.commit();


                }
                else if(tabId == R.id.tab_saldo){
                    FragmentManager fragManSaldo = getFragmentManager();
                    FragmentTransaction fragTransSaldo = fragManSaldo.beginTransaction();
                    FragSaldo fragSaldo = new FragSaldo();
                    fragTransSaldo.replace(R.id.contentContainer,fragSaldo);
                    fragTransSaldo.commit();
                }
                else if (tabId == R.id.tab_info)
                {
                    FragmentManager fragTabId = getFragmentManager();
                    FragmentTransaction fragTransInfo = fragTabId.beginTransaction();
                    FragInfo fragInfo = new FragInfo();
                    fragTransInfo.replace(R.id.contentContainer, fragInfo);
                    fragTransInfo.commit();
                }
                else if (tabId == R.id.tab_configuracoes)
                {
                    FragmentManager fragTabConfig = getFragmentManager();
                    FragmentTransaction fragTransInfo = fragTabConfig.beginTransaction();
                    FragConfig fragConfig = new FragConfig();
                    fragTransInfo.replace(R.id.contentContainer, fragConfig);
                    fragTransInfo.commit();
                }
            }
        });
    }

}
