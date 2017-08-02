package com.example.woo32.scii_ds_assistant;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String cost_Value;
    String armor_Value;
    String hp_Value;
    String type_Value;
    String range_a_Value;
    String range_g_Value;
    String move_Value;
    String dmg_g_Value, dmg_a_Value;
    String atkSp_g_Value, atkSp_a_Value;
    String dps_g_Value, dps_a_Value;
    String bouns_Value;
    int in=0;

    int[] T_costs={0,45,90,75,235,90,110,190,190,250,310,125,175,375,525,200};
    int[] T_armor={0,0,1,0,0,0,1,0,0,1,1,0,1,2,3,1};
    int[] T_hp=   {0,45,125,60,100,135,150,125,140,140,160,90,175,400,550,180};
    int[] T_type=   {0,00,10,00,30,00,11,01,01,01,11,01,11,16,16,11};  // 0 light 1 Armored 2 none 3 psi, 0 bio 1 mec 2 none 3 psi 4 massive 5 Bio-massive 6 Mec-massive
    int[] T_range_gnd={0,5,6,5,6,2,0,6,6,0,7,0,6,7, 6,0};
    int[] T_range_air={0,5,0,0,6,0,0,9,0,0,0,0,0,10,6,5};
    double[] T_move={0,3.15,3.15,5.25,3.94,3.15,3.5,3.85,3.85,3.85,3.15,3.94,4.13,2.62,2.62,4.72};
    int[] T_dmg_g={0,6,5,4,10,18,0,0,12,0,15,0,3,30,8,0};
    int[] T_dmg_a={0,6,0,0,10,0,0,10,0,0, 0, 0,0,6,6,5};
    int[] T_atks_g={0,1,2,2,1,1,0,0,2,0,1,0,1,2,1,0};
    int[] T_atks_a={0,1,0,0,1,0,0,2,0,0,0,0,0,4,1,2};
    double[] T_atkSp_g={0,0.61,1.07,0.79,1.07,1.43,0,0   ,0.89,0,0.74,0,0.1,0.91,0.16,0};
    double[] T_atkSp_a={0,0.61,0,0,      1.07,0   ,0,1.43,0,   0,   0,0,0  ,2.14,0.16,1.29};
    int[] T_bouns_type_g={0,0,2 , 0, 1, 0,0,0,0,0,2,   0,2, 0,0,0};    //0 none 1 light 2 Armored 3 Bio 4 Mec 5 Psi,
    int[] T_bouns_dmg_g ={0,0,5 , 0,10, 0,0,0,0,0,10,  0,2, 0,0,0};
    int[] T_bouns_type_a={-1,0,0 , 0, 1, 0,0,2,0,0,0,   0,0, 1,0,0};    //0 none 1 light 2 Armored 3 Bio 4 Mec 5 Psi,
    int[] T_bouns_dmg_a ={-1,0,0 , 0,10, 0,0,4,0,0,0,   0,0, 6,0,0};


    TextView cost;
    TextView armor;
    TextView hp;
    TextView type;
    TextView range_g;
    TextView range_a;
    TextView move;
    TextView dmg_g,dmg_a;
    TextView atkSp_g,atkSp_a;
    TextView dps_g,dps_a;
    TextView bouns;


    ImageButton T_marine;
    ImageButton T_marauder;
    ImageButton T_reaper;
    ImageButton T_ghost;
    ImageButton T_hellBat;
    ImageButton T_medivac;
    ImageButton T_viking;
    ImageButton T_banshee;
    ImageButton T_raven;
    ImageButton T_tank;
    ImageButton T_mine;
    ImageButton T_cyclone;
    ImageButton T_thor;
    ImageButton T_BC;
    ImageButton T_lib;


    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cost=(TextView) findViewById(R.id.textView_cost);
        armor=(TextView) findViewById(R.id.textView6_armor);
        hp=(TextView) findViewById(R.id.textView_hp);
        type=(TextView) findViewById(R.id.textView_type);
        range_a=(TextView) findViewById(R.id.textView_range_air);
        range_g=(TextView) findViewById(R.id.textView_range_gnd);
        move=(TextView) findViewById(R.id.textView_move);
        dmg_a=(TextView) findViewById(R.id.textView_dmg_a);
        dmg_g=(TextView) findViewById(R.id.textView_dmg_g);
        atkSp_g=(TextView) findViewById(R.id.textView_atkSp_g);
        atkSp_a=(TextView) findViewById(R.id.textView_atkSp_a);
        dps_g=(TextView) findViewById(R.id.textView_dps_g);
        dps_a=(TextView) findViewById(R.id.textView_dps_a);
        bouns=(TextView) findViewById(R.id.textView_bouns);
        //Terran units
        /////////////////////////////////////COST
        T_marine=(ImageButton)findViewById(R.id.imageButton1);
        T_marine.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int i=1;
                Log.d("@1-i: ", Integer.toString(i));
                cost_Value=Integer.toString(T_costs[i]);
                cost.setText(cost_Value);
                armor_Value=Integer.toString(T_armor[i]);
                armor.setText(armor_Value);
                hp_Value=Integer.toString(T_hp[i]);
                hp.setText(hp_Value);
                type_Value=typeTrans(T_type[i]); Log.d("@1",type_Value);
                type.setText( type_Value);
                range_a_Value=Integer.toString(T_range_air[i]);
                range_a.setText( range_a_Value);
                range_g_Value=Integer.toString(T_range_gnd[i]);
                range_g.setText( range_g_Value);
                move_Value=Double.toString(T_move[i]);
                move.setText( move_Value);

                dmg_g_Value=Integer.toString(T_dmg_g[i]);
                if(T_atks_g[i]>=2)
                    dmg_g_Value=dmg_g_Value+"x"+ Integer.toString(T_atks_g[i]);
                dmg_g.setText( dmg_g_Value);
                dmg_a_Value=Integer.toString(T_dmg_a[i]);
                if(T_atks_a[i]>=2)
                    dmg_a_Value=dmg_a_Value+"x"+ Integer.toString(T_atks_a[i]);
                dmg_a.setText( dmg_a_Value);

                atkSp_g_Value=Double.toString(T_atkSp_g[i]);
                atkSp_g.setText( atkSp_g_Value);
                atkSp_a_Value=Double.toString(T_atkSp_a[i]);
                atkSp_a.setText( atkSp_a_Value);
                dps_g_Value=Double.toString( (Math.round (     (T_dmg_g[i]*T_atks_g[i] )/ T_atkSp_g[i]*100)  ) *0.01     );
                dps_g.setText( dps_g_Value);
                dps_a_Value=Double.toString( (Math.round (     (T_dmg_a[i]*T_atks_a[i] )/ T_atkSp_a[i]*100)  ) *0.01     );
                dps_a.setText( dps_a_Value);
                if(T_bouns_type_g[i]>0){
                    bouns_Value=bounsTrans(T_bouns_type_g[i],T_bouns_dmg_g[i],0);
                }else if((T_bouns_type_a[i]>0)){
                    bouns_Value=bounsTrans(T_bouns_type_a[i],T_bouns_dmg_a[i],1);
                }
                else
                    bouns_Value="N/A";



                bouns.setText( bouns_Value);

            }
        });

        T_marauder=(ImageButton)findViewById(R.id.imageButton2);
        T_marauder.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int i=2;
                cost_Value=Integer.toString(T_costs[i]);
                cost.setText(cost_Value);
                armor_Value=Integer.toString(T_armor[i]);
                armor.setText(armor_Value);
                hp_Value=Integer.toString(T_hp[i]);
                hp.setText(hp_Value);
                type_Value=typeTrans(T_type[i]);Log.d("@2",type_Value);
                type.setText(type_Value);
                range_a_Value=Integer.toString(T_range_air[i]);
                range_a.setText( range_a_Value);
                range_g_Value=Integer.toString(T_range_gnd[i]);
                range_g.setText( range_g_Value);
                move_Value=Double.toString(T_move[i]);
                move.setText( move_Value);
                dmg_g_Value=Integer.toString(T_dmg_g[i]);
                if(T_atks_g[i]>=2)
                    dmg_g_Value=dmg_g_Value+"x"+ Integer.toString(T_atks_g[i]);
                dmg_g.setText( dmg_g_Value);
                dmg_a_Value=Integer.toString(T_dmg_a[i]);
                if(T_atks_a[i]>=2)
                    dmg_a_Value=dmg_a_Value+"x"+ Integer.toString(T_atks_a[i]);
                dmg_a.setText( dmg_a_Value);

                atkSp_g_Value=Double.toString(T_atkSp_g[i]);
                atkSp_g.setText( atkSp_g_Value);
                atkSp_a_Value=Double.toString(T_atkSp_a[i]);
                atkSp_a.setText( atkSp_a_Value);
                dps_g_Value=Double.toString( (Math.round (     (T_dmg_g[i]*T_atks_g[i] )/ T_atkSp_g[i]*100)  ) *0.01     );
                dps_g.setText( dps_g_Value);
                dps_a_Value=Double.toString( (Math.round (     (T_dmg_a[i]*T_atks_a[i] )/ T_atkSp_a[i]*100)  ) *0.01     );
                dps_a.setText( dps_a_Value);

                if(T_bouns_type_g[i]>0){
                    bouns_Value=bounsTrans(T_bouns_type_g[i],T_bouns_dmg_g[i],0);
                }else if((T_bouns_type_a[i]>0)){
                    bouns_Value=bounsTrans(T_bouns_type_a[i],T_bouns_dmg_a[i],1);
                }
                else
                    bouns_Value="N/A";
                bouns.setText( bouns_Value);

            }
        });

        T_reaper=(ImageButton)findViewById(R.id.imageButton3);
        T_reaper.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int i=3;
                cost_Value=Integer.toString(T_costs[i]);
                cost.setText(cost_Value);
                armor_Value=Integer.toString(T_armor[i]);
                armor.setText(armor_Value);
                hp_Value=Integer.toString(T_hp[i]);
                hp.setText(hp_Value);
                type_Value=typeTrans(T_type[i]);
                type.setText(type_Value);
                range_a_Value=Integer.toString(T_range_air[i]);
                range_a.setText( range_a_Value);
                range_g_Value=Integer.toString(T_range_gnd[i]);
                range_g.setText( range_g_Value);
                move_Value=Double.toString(T_move[i]);
                move.setText( move_Value);
                dmg_g_Value=Integer.toString(T_dmg_g[i]);
                if(T_atks_g[i]>=2)
                    dmg_g_Value=dmg_g_Value+"x"+ Integer.toString(T_atks_g[i]);
                dmg_g.setText( dmg_g_Value);
                dmg_a_Value=Integer.toString(T_dmg_a[i]);
                if(T_atks_a[i]>=2)
                    dmg_a_Value=dmg_a_Value+"x"+ Integer.toString(T_atks_a[i]);
                dmg_a.setText( dmg_a_Value);
                atkSp_g_Value=Double.toString(T_atkSp_g[i]);
                atkSp_g.setText( atkSp_g_Value);
                atkSp_a_Value=Double.toString(T_atkSp_a[i]);
                atkSp_a.setText( atkSp_a_Value);
                dps_g_Value=Double.toString( (Math.round (     (T_dmg_g[i]*T_atks_g[i] )/ T_atkSp_g[i]*100)  ) *0.01     );
                dps_g.setText( dps_g_Value);
                dps_a_Value=Double.toString( (Math.round (     (T_dmg_a[i]*T_atks_a[i] )/ T_atkSp_a[i]*100)  ) *0.01     );
                dps_a.setText( dps_a_Value);
                if(T_bouns_type_g[i]>0){
                    bouns_Value=bounsTrans(T_bouns_type_g[i],T_bouns_dmg_g[i],0);
                }else if((T_bouns_type_a[i]>0)){
                    bouns_Value=bounsTrans(T_bouns_type_a[i],T_bouns_dmg_a[i],1);
                }
                else
                    bouns_Value="N/A";
                bouns.setText( bouns_Value);


            }
        });

        T_ghost=(ImageButton)findViewById(R.id.imageButton4);
        T_ghost.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int i=4;
                cost_Value=Integer.toString(T_costs[i]);
                cost.setText(cost_Value);
                armor_Value=Integer.toString(T_armor[i]);
                armor.setText(armor_Value);
                hp_Value=Integer.toString(T_hp[i]);
                hp.setText(hp_Value);
                type_Value=typeTrans(T_type[i]);
                type.setText(type_Value);
                range_a_Value=Integer.toString(T_range_air[i]);
                range_a.setText( range_a_Value);
                range_g_Value=Integer.toString(T_range_gnd[i]);
                range_g.setText( range_g_Value);
                move_Value=Double.toString(T_move[i]);
                move.setText( move_Value);
                dmg_g_Value=Integer.toString(T_dmg_g[i]);
                if(T_atks_g[i]>=2)
                    dmg_g_Value=dmg_g_Value+"x"+ Integer.toString(T_atks_g[i]);
                dmg_g.setText( dmg_g_Value);
                dmg_a_Value=Integer.toString(T_dmg_a[i]);
                if(T_atks_a[i]>=2)
                    dmg_a_Value=dmg_a_Value+"x"+ Integer.toString(T_atks_a[i]);
                dmg_a.setText( dmg_a_Value);
                atkSp_g_Value=Double.toString(T_atkSp_g[i]);
                atkSp_g.setText( atkSp_g_Value);
                atkSp_a_Value=Double.toString(T_atkSp_a[i]);
                atkSp_a.setText( atkSp_a_Value);
                dps_g_Value=Double.toString( (Math.round (     (T_dmg_g[i]*T_atks_g[i] )/ T_atkSp_g[i]*100)  ) *0.01     );
                dps_g.setText( dps_g_Value);
                dps_a_Value=Double.toString( (Math.round (     (T_dmg_a[i]*T_atks_a[i] )/ T_atkSp_a[i]*100)  ) *0.01     );
                dps_a.setText( dps_a_Value);
                if(T_bouns_type_g[i]>0){
                    if(T_bouns_type_a[i]>0)
                        bouns_Value=bounsTrans(T_bouns_type_g[i],T_bouns_dmg_g[i],3);
                    else
                        bouns_Value=bounsTrans(T_bouns_type_g[i],T_bouns_dmg_g[i],0);
                }else if((T_bouns_type_a[i]>0)){
                    bouns_Value=bounsTrans(T_bouns_type_a[i],T_bouns_dmg_a[i],1);
                }
                else
                    bouns_Value="N/A";
                bouns.setText( bouns_Value);


            }
        });

        T_hellBat=(ImageButton)findViewById(R.id.imageButton5);
        T_hellBat.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int i=5;
                cost_Value=Integer.toString(T_costs[i]);
                cost.setText(cost_Value);
                armor_Value=Integer.toString(T_armor[i]);
                armor.setText(armor_Value);
                hp_Value=Integer.toString(T_hp[i]);
                hp.setText(hp_Value);
                type_Value=typeTrans(T_type[i]);
                type.setText(type_Value);
                range_a_Value=Integer.toString(T_range_air[i]);
                range_a.setText( range_a_Value);
                range_g_Value=Integer.toString(T_range_gnd[i]);
                range_g.setText( range_g_Value);
                move_Value=Double.toString(T_move[i]);
                move.setText( move_Value);
                dmg_g_Value=Integer.toString(T_dmg_g[i]);
                if(T_atks_g[i]>=2)
                    dmg_g_Value=dmg_g_Value+"x"+ Integer.toString(T_atks_g[i]);
                dmg_g.setText( dmg_g_Value);
                dmg_a_Value=Integer.toString(T_dmg_a[i]);
                if(T_atks_a[i]>=2)
                    dmg_a_Value=dmg_a_Value+"x"+ Integer.toString(T_atks_a[i]);
                dmg_a.setText( dmg_a_Value);
                atkSp_g_Value=Double.toString(T_atkSp_g[i]);
                atkSp_g.setText( atkSp_g_Value);
                atkSp_a_Value=Double.toString(T_atkSp_a[i]);
                atkSp_a.setText( atkSp_a_Value);
                dps_g_Value=Double.toString( (Math.round (     (T_dmg_g[i]*T_atks_g[i] )/ T_atkSp_g[i]*100)  ) *0.01     );
                dps_g.setText( dps_g_Value);
                dps_a_Value=Double.toString( (Math.round (     (T_dmg_a[i]*T_atks_a[i] )/ T_atkSp_a[i]*100)  ) *0.01     );
                dps_a.setText( dps_a_Value);
                if(T_bouns_type_g[i]>0){
                    bouns_Value=bounsTrans(T_bouns_type_g[i],T_bouns_dmg_g[i],0);
                }else if((T_bouns_type_a[i]>0)){
                    bouns_Value=bounsTrans(T_bouns_type_a[i],T_bouns_dmg_a[i],1);
                }
                else
                    bouns_Value="N/A";
                bouns.setText( bouns_Value);


            }
        });

        T_medivac=(ImageButton)findViewById(R.id.imageButton6);
        T_medivac.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int i=6;
                cost_Value=Integer.toString(T_costs[i]);
                cost.setText(cost_Value);
                armor_Value=Integer.toString(T_armor[i]);
                armor.setText(armor_Value);
                hp_Value=Integer.toString(T_hp[i]);
                hp.setText(hp_Value);
                type_Value=typeTrans(T_type[i]);
                type.setText(type_Value);
                range_a_Value=Integer.toString(T_range_air[i]);
                range_a.setText( range_a_Value);
                range_g_Value=Integer.toString(T_range_gnd[i]);
                range_g.setText( range_g_Value);
                move_Value=Double.toString(T_move[i]);
                move.setText( move_Value);
                dmg_g_Value=Integer.toString(T_dmg_g[i]);
                if(T_atks_g[i]>=2)
                    dmg_g_Value=dmg_g_Value+"x"+ Integer.toString(T_atks_g[i]);
                dmg_g.setText( dmg_g_Value);
                dmg_a_Value=Integer.toString(T_dmg_a[i]);
                if(T_atks_a[i]>=2)
                    dmg_a_Value=dmg_a_Value+"x"+ Integer.toString(T_atks_a[i]);
                dmg_a.setText( dmg_a_Value);
                atkSp_g_Value=Double.toString(T_atkSp_g[i]);
                atkSp_g.setText( atkSp_g_Value);
                atkSp_a_Value=Double.toString(T_atkSp_a[i]);
                atkSp_a.setText( atkSp_a_Value);
                dps_g_Value=Double.toString( (Math.round (     (T_dmg_g[i]*T_atks_g[i] )/ T_atkSp_g[i]*100)  ) *0.01     );
                dps_g.setText( dps_g_Value);
                dps_a_Value=Double.toString( (Math.round (     (T_dmg_a[i]*T_atks_a[i] )/ T_atkSp_a[i]*100)  ) *0.01     );
                dps_a.setText( dps_a_Value);
                if(T_bouns_type_g[i]>0){
                    bouns_Value=bounsTrans(T_bouns_type_g[i],T_bouns_dmg_g[i],0);
                }else if((T_bouns_type_a[i]>0)){
                    bouns_Value=bounsTrans(T_bouns_type_a[i],T_bouns_dmg_a[i],1);
                }
                else
                    bouns_Value="N/A";
                bouns.setText( bouns_Value);


            }
        });

        T_viking=(ImageButton)findViewById(R.id.imageButton7);
        T_viking.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int i=7;
                cost_Value=Integer.toString(T_costs[i]);
                cost.setText(cost_Value);
                armor_Value=Integer.toString(T_armor[i]);
                armor.setText(armor_Value);
                hp_Value=Integer.toString(T_hp[i]);
                hp.setText(hp_Value);
                type_Value=typeTrans(T_type[i]);
                type.setText(type_Value);
                range_a_Value=Integer.toString(T_range_air[i]);
                range_a.setText( range_a_Value);
                range_g_Value=Integer.toString(T_range_gnd[i]);
                range_g.setText( range_g_Value);
                move_Value=Double.toString(T_move[i]);
                move.setText( move_Value);
                dmg_g_Value=Integer.toString(T_dmg_g[i]);
                if(T_atks_g[i]>=2)
                    dmg_g_Value=dmg_g_Value+"x"+ Integer.toString(T_atks_g[i]);
                dmg_g.setText( dmg_g_Value);
                dmg_a_Value=Integer.toString(T_dmg_a[i]);
                if(T_atks_a[i]>=2)
                    dmg_a_Value=dmg_a_Value+"x"+ Integer.toString(T_atks_a[i]);
                dmg_a.setText( dmg_a_Value);
                atkSp_g_Value=Double.toString(T_atkSp_g[i]);
                atkSp_g.setText( atkSp_g_Value);
                atkSp_a_Value=Double.toString(T_atkSp_a[i]);
                atkSp_a.setText( atkSp_a_Value);
                dps_g_Value=Double.toString( (Math.round (     (T_dmg_g[i]*T_atks_g[i] )/ T_atkSp_g[i]*100)  ) *0.01     );
                dps_g.setText( dps_g_Value);
                dps_a_Value=Double.toString( (Math.round (     (T_dmg_a[i]*T_atks_a[i] )/ T_atkSp_a[i]*100)  ) *0.01     );
                dps_a.setText( dps_a_Value);
                if(T_bouns_type_g[i]>0){
                    bouns_Value=bounsTrans(T_bouns_type_g[i],T_bouns_dmg_g[i],0);
                }else if((T_bouns_type_a[i]>0)){
                    bouns_Value=bounsTrans(T_bouns_type_a[i],T_bouns_dmg_a[i],1);
                }
                else
                    bouns_Value="N/A";
                bouns.setText( bouns_Value);

            }
        });

        T_banshee=(ImageButton)findViewById(R.id.imageButton8);
        T_banshee.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int i=8;
                cost_Value=Integer.toString(T_costs[i]);
                cost.setText(cost_Value);
                armor_Value=Integer.toString(T_armor[i]);
                armor.setText(armor_Value);
                hp_Value=Integer.toString(T_hp[i]);
                hp.setText(hp_Value);
                type_Value=typeTrans(T_type[i]);
                type.setText(type_Value);
                range_a_Value=Integer.toString(T_range_air[i]);
                range_a.setText( range_a_Value);
                range_g_Value=Integer.toString(T_range_gnd[i]);
                range_g.setText( range_g_Value);
                move_Value=Double.toString(T_move[i]);
                move.setText( move_Value);
                dmg_g_Value=Integer.toString(T_dmg_g[i]);
                if(T_atks_g[i]>=2)
                    dmg_g_Value=dmg_g_Value+"x"+ Integer.toString(T_atks_g[i]);
                dmg_g.setText( dmg_g_Value);
                dmg_a_Value=Integer.toString(T_dmg_a[i]);
                if(T_atks_a[i]>=2)
                    dmg_a_Value=dmg_a_Value+"x"+ Integer.toString(T_atks_a[i]);
                dmg_a.setText( dmg_a_Value);
                atkSp_g_Value=Double.toString(T_atkSp_g[i]);
                atkSp_g.setText( atkSp_g_Value);
                atkSp_a_Value=Double.toString(T_atkSp_a[i]);
                atkSp_a.setText( atkSp_a_Value);
                dps_g_Value=Double.toString( (Math.round (     (T_dmg_g[i]*T_atks_g[i] )/ T_atkSp_g[i]*100)  ) *0.01     );
                dps_g.setText( dps_g_Value);
                dps_a_Value=Double.toString( (Math.round (     (T_dmg_a[i]*T_atks_a[i] )/ T_atkSp_a[i]*100)  ) *0.01     );
                dps_a.setText( dps_a_Value);
                if(T_bouns_type_g[i]>0){
                    bouns_Value=bounsTrans(T_bouns_type_g[i],T_bouns_dmg_g[i],0);
                }else if((T_bouns_type_a[i]>0)){
                    bouns_Value=bounsTrans(T_bouns_type_a[i],T_bouns_dmg_a[i],1);
                }
                else
                    bouns_Value="N/A";
                bouns.setText( bouns_Value);


            }
        });

        T_raven=(ImageButton)findViewById(R.id.imageButton9);
        T_raven.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int i=9;
                cost_Value=Integer.toString(T_costs[i]);
                cost.setText(cost_Value);
                armor_Value=Integer.toString(T_armor[i]);
                armor.setText(armor_Value);
                hp_Value=Integer.toString(T_hp[i]);
                hp.setText(hp_Value);
                type_Value=typeTrans(T_type[i]);
                type.setText(type_Value);
                range_a_Value=Integer.toString(T_range_air[i]);
                range_a.setText( range_a_Value);
                range_g_Value=Integer.toString(T_range_gnd[i]);
                range_g.setText( range_g_Value);
                move_Value=Double.toString(T_move[i]);
                move.setText( move_Value);
                dmg_g_Value=Integer.toString(T_dmg_g[i]);
                if(T_atks_g[i]>=2)
                    dmg_g_Value=dmg_g_Value+"x"+ Integer.toString(T_atks_g[i]);
                dmg_g.setText( dmg_g_Value);
                dmg_a_Value=Integer.toString(T_dmg_a[i]);
                if(T_atks_a[i]>=2)
                    dmg_a_Value=dmg_a_Value+"x"+ Integer.toString(T_atks_a[i]);
                dmg_a.setText( dmg_a_Value);
                atkSp_g_Value=Double.toString(T_atkSp_g[i]);
                atkSp_g.setText( atkSp_g_Value);
                atkSp_a_Value=Double.toString(T_atkSp_a[i]);
                atkSp_a.setText( atkSp_a_Value);
                dps_g_Value=Double.toString( (Math.round (     (T_dmg_g[i]*T_atks_g[i] )/ T_atkSp_g[i]*100)  ) *0.01     );
                dps_g.setText( dps_g_Value);
                dps_a_Value=Double.toString( (Math.round (     (T_dmg_a[i]*T_atks_a[i] )/ T_atkSp_a[i]*100)  ) *0.01     );
                dps_a.setText( dps_a_Value);
                if(T_bouns_type_g[i]>0){
                    bouns_Value=bounsTrans(T_bouns_type_g[i],T_bouns_dmg_g[i],0);
                }else if((T_bouns_type_a[i]>0)){
                    bouns_Value=bounsTrans(T_bouns_type_a[i],T_bouns_dmg_a[i],1);
                }
                else
                    bouns_Value="N/A";
                bouns.setText( bouns_Value);

            }
        });

        T_tank=(ImageButton)findViewById(R.id.imageButton10);
        T_tank.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int i=10;
                cost_Value=Integer.toString(T_costs[i]);
                cost.setText(cost_Value);
                armor_Value=Integer.toString(T_armor[i]);
                armor.setText(armor_Value);
                hp_Value=Integer.toString(T_hp[i]);
                hp.setText(hp_Value);
                type_Value=typeTrans(T_type[i]);
                type.setText(type_Value);
                range_a_Value=Integer.toString(T_range_air[i]);
                range_a.setText( range_a_Value);
                range_g_Value=Integer.toString(T_range_gnd[i]);
                range_g.setText( range_g_Value);
                move_Value=Double.toString(T_move[i]);
                move.setText( move_Value);
                dmg_g_Value=Integer.toString(T_dmg_g[i]);
                if(T_atks_g[i]>=2)
                    dmg_g_Value=dmg_g_Value+"x"+ Integer.toString(T_atks_g[i]);
                dmg_g.setText( dmg_g_Value);
                dmg_a_Value=Integer.toString(T_dmg_a[i]);
                if(T_atks_a[i]>=2)
                    dmg_a_Value=dmg_a_Value+"x"+ Integer.toString(T_atks_a[i]);
                dmg_a.setText( dmg_a_Value);
                atkSp_g_Value=Double.toString(T_atkSp_g[i]);
                atkSp_g.setText( atkSp_g_Value);
                atkSp_a_Value=Double.toString(T_atkSp_a[i]);
                atkSp_a.setText( atkSp_a_Value);
                dps_g_Value=Double.toString( (Math.round (     (T_dmg_g[i]*T_atks_g[i] )/ T_atkSp_g[i]*100)  ) *0.01     );
                dps_g.setText( dps_g_Value);
                dps_a_Value=Double.toString( (Math.round (     (T_dmg_a[i]*T_atks_a[i] )/ T_atkSp_a[i]*100)  ) *0.01     );
                dps_a.setText( dps_a_Value);
                if(T_bouns_type_g[i]>0){
                    bouns_Value=bounsTrans(T_bouns_type_g[i],T_bouns_dmg_g[i],0);
                }else if((T_bouns_type_a[i]>0)){
                    bouns_Value=bounsTrans(T_bouns_type_a[i],T_bouns_dmg_a[i],1);
                }
                else
                    bouns_Value="N/A";
                bouns.setText( bouns_Value);

            }
        });

        T_mine=(ImageButton)findViewById(R.id.imageButton11);
        T_mine.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int i=11;
                cost_Value=Integer.toString(T_costs[i]);
                cost.setText(cost_Value);
                armor_Value=Integer.toString(T_armor[i]);
                armor.setText(armor_Value);
                hp_Value=Integer.toString(T_hp[i]);
                hp.setText(hp_Value);
                type_Value=typeTrans(T_type[i]);
                type.setText(type_Value);
                range_a_Value=Integer.toString(T_range_air[i]);
                range_a.setText( range_a_Value);
                range_g_Value=Integer.toString(T_range_gnd[i]);
                range_g.setText( range_g_Value);
                move_Value=Double.toString(T_move[i]);
                move.setText( move_Value);
                dmg_g_Value=Integer.toString(T_dmg_g[i]);
                if(T_atks_g[i]>=2)
                    dmg_g_Value=dmg_g_Value+"x"+ Integer.toString(T_atks_g[i]);
                dmg_g.setText( dmg_g_Value);
                dmg_a_Value=Integer.toString(T_dmg_a[i]);
                if(T_atks_a[i]>=2)
                    dmg_a_Value=dmg_a_Value+"x"+ Integer.toString(T_atks_a[i]);
                dmg_a.setText( dmg_a_Value);
                atkSp_g_Value=Double.toString(T_atkSp_g[i]);
                atkSp_g.setText( atkSp_g_Value);
                atkSp_a_Value=Double.toString(T_atkSp_a[i]);
                atkSp_a.setText( atkSp_a_Value);
                dps_g_Value=Double.toString( (Math.round (     (T_dmg_g[i]*T_atks_g[i] )/ T_atkSp_g[i]*100)  ) *0.01     );
                dps_g.setText( dps_g_Value);
                dps_a_Value=Double.toString( (Math.round (     (T_dmg_a[i]*T_atks_a[i] )/ T_atkSp_a[i]*100)  ) *0.01     );
                dps_a.setText( dps_a_Value);
                if(T_bouns_type_g[i]>0){
                    bouns_Value=bounsTrans(T_bouns_type_g[i],T_bouns_dmg_g[i],0);
                }else if((T_bouns_type_a[i]>0)){
                    bouns_Value=bounsTrans(T_bouns_type_a[i],T_bouns_dmg_a[i],1);
                }
                else
                    bouns_Value="N/A";
                bouns.setText( bouns_Value);


            }
        });

        T_cyclone=(ImageButton)findViewById(R.id.imageButton12);
        T_cyclone.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int i=12;
                cost_Value=Integer.toString(T_costs[i]);
                cost.setText(cost_Value);
                armor_Value=Integer.toString(T_armor[i]);
                armor.setText(armor_Value);
                hp_Value=Integer.toString(T_hp[i]);
                hp.setText(hp_Value);
                type_Value=typeTrans(T_type[i]);
                type.setText(type_Value);
                range_a_Value=Integer.toString(T_range_air[i]);
                range_a.setText( range_a_Value);
                range_g_Value=Integer.toString(T_range_gnd[i]);
                range_g.setText( range_g_Value);
                move_Value=Double.toString(T_move[i]);
                move.setText( move_Value);
                dmg_g_Value=Integer.toString(T_dmg_g[i]);
                if(T_atks_g[i]>=2)
                    dmg_g_Value=dmg_g_Value+"x"+ Integer.toString(T_atks_g[i]);
                dmg_g.setText( dmg_g_Value);
                dmg_a_Value=Integer.toString(T_dmg_a[i]);
                if(T_atks_a[i]>=2)
                    dmg_a_Value=dmg_a_Value+"x"+ Integer.toString(T_atks_a[i]);
                dmg_a.setText( dmg_a_Value);
                atkSp_g_Value=Double.toString(T_atkSp_g[i]);
                atkSp_g.setText( atkSp_g_Value);
                atkSp_a_Value=Double.toString(T_atkSp_a[i]);
                atkSp_a.setText( atkSp_a_Value);
                dps_g_Value=Double.toString( (Math.round (     (T_dmg_g[i]*T_atks_g[i] )/ T_atkSp_g[i]*100)  ) *0.01     );
                dps_g.setText( dps_g_Value);
                dps_a_Value=Double.toString( (Math.round (     (T_dmg_a[i]*T_atks_a[i] )/ T_atkSp_a[i]*100)  ) *0.01     );
                dps_a.setText( dps_a_Value);
                if(T_bouns_type_g[i]>0){
                    bouns_Value=bounsTrans(T_bouns_type_g[i],T_bouns_dmg_g[i],0);
                }else if((T_bouns_type_a[i]>0)){
                    bouns_Value=bounsTrans(T_bouns_type_a[i],T_bouns_dmg_a[i],1);
                }
                else
                    bouns_Value="N/A";
                bouns.setText( bouns_Value);


            }
        });

        T_thor=(ImageButton)findViewById(R.id.imageButton13);
        T_thor.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int i=13;
                cost_Value=Integer.toString(T_costs[i]);
                cost.setText(cost_Value);
                armor_Value=Integer.toString(T_armor[i]);
                armor.setText(armor_Value);
                hp_Value=Integer.toString(T_hp[i]);
                hp.setText(hp_Value);
                type_Value=typeTrans(T_type[i]);
                type.setText(type_Value);
                range_a_Value=Integer.toString(T_range_air[i]);
                range_a.setText( range_a_Value);
                range_g_Value=Integer.toString(T_range_gnd[i]);
                range_g.setText( range_g_Value);
                move_Value=Double.toString(T_move[i]);
                move.setText( move_Value);
                dmg_g_Value=Integer.toString(T_dmg_g[i]);
                if(T_atks_g[i]>=2)
                    dmg_g_Value=dmg_g_Value+"x"+ Integer.toString(T_atks_g[i]);
                dmg_g.setText( dmg_g_Value);
                dmg_a_Value=Integer.toString(T_dmg_a[i]);
                if(T_atks_a[i]>=2)
                    dmg_a_Value=dmg_a_Value+"x"+ Integer.toString(T_atks_a[i]);
                dmg_a.setText( dmg_a_Value);
                atkSp_g_Value=Double.toString(T_atkSp_g[i]);
                atkSp_g.setText( atkSp_g_Value);
                atkSp_a_Value=Double.toString(T_atkSp_a[i]);
                atkSp_a.setText( atkSp_a_Value);
                dps_g_Value=Double.toString( (Math.round (     (T_dmg_g[i]*T_atks_g[i] )/ T_atkSp_g[i]*100)  ) *0.01     );
                dps_g.setText( dps_g_Value);
                dps_a_Value=Double.toString( (Math.round (     (T_dmg_a[i]*T_atks_a[i] )/ T_atkSp_a[i]*100)  ) *0.01     );
                dps_a.setText( dps_a_Value);
                if(T_bouns_type_g[i]>0){
                    bouns_Value=bounsTrans(T_bouns_type_g[i],T_bouns_dmg_g[i],0);
                }else if((T_bouns_type_a[i]>0)){
                    bouns_Value=bounsTrans(T_bouns_type_a[i],T_bouns_dmg_a[i],1);
                }
                else
                    bouns_Value="N/A";
                bouns.setText( bouns_Value);


            }
        });

        T_BC=(ImageButton)findViewById(R.id.imageButton14);
        T_BC.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int i=14;
                cost_Value=Integer.toString(T_costs[i]);
                cost.setText(cost_Value);
                armor_Value=Integer.toString(T_armor[i]);
                armor.setText(armor_Value);
                hp_Value=Integer.toString(T_hp[i]);
                hp.setText(hp_Value);
                type_Value=typeTrans(T_type[i]);
                type.setText(type_Value);
                range_a_Value=Integer.toString(T_range_air[i]);
                range_a.setText( range_a_Value);
                range_g_Value=Integer.toString(T_range_gnd[i]);
                range_g.setText( range_g_Value);
                move_Value=Double.toString(T_move[i]);
                move.setText( move_Value);
                dmg_g_Value=Integer.toString(T_dmg_g[i]);
                if(T_atks_g[i]>=2)
                    dmg_g_Value=dmg_g_Value+"x"+ Integer.toString(T_atks_g[i]);
                dmg_g.setText( dmg_g_Value);
                dmg_a_Value=Integer.toString(T_dmg_a[i]);
                if(T_atks_a[i]>=2)
                    dmg_a_Value=dmg_a_Value+"x"+ Integer.toString(T_atks_a[i]);
                dmg_a.setText( dmg_a_Value);
                atkSp_g_Value=Double.toString(T_atkSp_g[i]);
                atkSp_g.setText( atkSp_g_Value);
                atkSp_a_Value=Double.toString(T_atkSp_a[i]);
                atkSp_a.setText( atkSp_a_Value);
                dps_g_Value=Double.toString( (Math.round (     (T_dmg_g[i]*T_atks_g[i] )/ T_atkSp_g[i]*100)  ) *0.01     );
                dps_g.setText( dps_g_Value);
                dps_a_Value=Double.toString( (Math.round (     (T_dmg_a[i]*T_atks_a[i] )/ T_atkSp_a[i]*100)  ) *0.01     );
                dps_a.setText( dps_a_Value);
                if(T_bouns_type_g[i]>0){
                    bouns_Value=bounsTrans(T_bouns_type_g[i],T_bouns_dmg_g[i],0);
                }else if((T_bouns_type_a[i]>0)){
                    bouns_Value=bounsTrans(T_bouns_type_a[i],T_bouns_dmg_a[i],1);
                }
                else
                    bouns_Value="N/A";
                bouns.setText( bouns_Value);


            }
        });

        T_lib=(ImageButton)findViewById(R.id.imageButton15);
        T_lib.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int i=15;
                cost_Value=Integer.toString(T_costs[i]);
                cost.setText(cost_Value);
                armor_Value=Integer.toString(T_armor[i]);
                armor.setText(armor_Value);
                hp_Value=Integer.toString(T_hp[i]);
                hp.setText(hp_Value);
                type_Value=typeTrans(T_type[i]);
                type.setText(type_Value);
                range_a_Value=Integer.toString(T_range_air[i]);
                range_a.setText( range_a_Value);
                range_g_Value=Integer.toString(T_range_gnd[i]);
                range_g.setText( range_g_Value);
                move_Value=Double.toString(T_move[i]);
                move.setText( move_Value);
                dmg_g_Value=Integer.toString(T_dmg_g[i]);
                if(T_atks_g[i]>=2)
                    dmg_g_Value=dmg_g_Value+"x"+ Integer.toString(T_atks_g[i]);
                dmg_g.setText( dmg_g_Value);
                dmg_a_Value=Integer.toString(T_dmg_a[i]);
                if(T_atks_a[i]>=2)
                    dmg_a_Value=dmg_a_Value+"x"+ Integer.toString(T_atks_a[i]);
                dmg_a.setText( dmg_a_Value);
                atkSp_g_Value=Double.toString(T_atkSp_g[i]);
                atkSp_g.setText( atkSp_g_Value);
                atkSp_a_Value=Double.toString(T_atkSp_a[i]);
                atkSp_a.setText( atkSp_a_Value);
                dps_g_Value=Double.toString( (Math.round (     (T_dmg_g[i]*T_atks_g[i] )/ T_atkSp_g[i]*100)  ) *0.01     );
                dps_g.setText( dps_g_Value);
                dps_a_Value=Double.toString( (Math.round (     (T_dmg_a[i]*T_atks_a[i] )/ T_atkSp_a[i]*100)  ) *0.01     );
                dps_a.setText( dps_a_Value);
                if(T_bouns_type_g[i]>0){
                    bouns_Value=bounsTrans(T_bouns_type_g[i],T_bouns_dmg_g[i],0);
                }else if((T_bouns_type_a[i]>0)){
                    bouns_Value=bounsTrans(T_bouns_type_a[i],T_bouns_dmg_a[i],1);
                }
                else
                    bouns_Value="N/A";
                bouns.setText( bouns_Value);


            }
        });


        //mTextMessage = (TextView) findViewById(R.id.message);
        //BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
       // navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    String bounsTrans(int type, int dmg,int GorA){ //type: 0 none 1 light 2 Armored 3 Bio 4 Mec 5 Psi,
        String s="";

        if(GorA==0 && type!=0)// gnd
            s=s+"Gnd-";
        else if(GorA==1 && type!=0)// gnd
            s=s+"Air-";
        else if(GorA==3 && type!=0)
            s=s;
        else
            return "N/A";

        if(type==1)
            s=s+"Lig+";
        else if(type==2)
            s=s+"Arm+";
        else if(type==3)
            s=s+"Bio+";
        else if(type==4)
            s=s+"Mec+";
        else if(type==5)
            s=s+"Psi+";
        else  if(type==6)
            s=s+"Ma+";
        else
            return "N/A";

        s=s+Integer.toString(dmg);

        return s;
    }

    // 0 light 1 Armored 2 none 3 psi, 0 bio 1 mec 2 none 3 psi 4 massive 5 Bio-massive 6 Mec-massive
    String typeTrans(int input){
        String s="";
        if(input/10==0)
            s=s+"Light";
        else if(input/10==1)
            s=s+"Armored";
        else if(input/10==3)
            s=s+"Psi";

        s=s+"-";

        if(input%10==0)
            s=s+"Bio";
        else if(input%10==1)
            s=s+"Mec";
        else if(input%10==3)
            s=s+"Psi";
        else if(input%10==4)
            s=s+"Ma";
        else if(input%10==5)
            s=s+"Bio-Ma";
        else if(input%10==6)
            s=s+"Mec-Ma";
        return s;
    }
}
