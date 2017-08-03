package com.example.woo32.scii_ds_assistant;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {// ss
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

    int current=0; //Terran=1x Protoss=2x Zerg=3x

    int[] T_costs={0,45,90,75,235,90,110,190,190,250,310,125,175,375,525,200};
    int[] T_armor={0,0,1,0,0,0,1,0,0,1,1,0,1,2,3,1};
    int[] T_hp=   {0,45,125,60,100,135,150,125,140,140,175,90,180,400,550,180};
    int[] T_type=   {0,00,10,00,30,07,11,01,01,01,11,01,11,16,16,11};  // 0 light 1 Armored 2 none 3 psi, 0 bio 1 mec 2 none 3 psi 4 massive 5 Bio-massive 6 Mec-massive 7 Bio-Mec
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
    TextView shieldHp;



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
    ImageButton upgrade1;
    ImageButton upgrade2;
    ImageButton upgrade3;
    ImageButton skill1;
    ImageButton skill2;
    ImageButton skill3;

    boolean hellbatOFF=false;
    boolean turret=false;
    boolean lib_defON=false;

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
        shieldHp=(TextView) findViewById(R.id.textView_hpBouns);

        //upgrades
        upgrade1=(ImageButton)findViewById(R.id.imageButton_upgrade1);
        upgrade1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(current==1){//marine-shield

                    hp.setText("55");
                }
                else if(current==5){
                    if(hellbatOFF==false)
                        bouns.setText("Gnd-Lig+12");
                    else
                        bouns.setText("Gnd-Lig+11");
                }else if(current==15){
                    if(lib_defON==true)
                       range_g.setText("9");

                }

            }
        });

        upgrade2=(ImageButton)findViewById(R.id.imageButton_upgrade2);
        upgrade2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(current==1 || current == 2){//marine/maruder -stimpack  150% speed
                    double tempSp_g= T_atkSp_g[current];
                    double tempSp_a= T_atkSp_a[current];
                    double tempDps_g,tempDps_a;
                    tempSp_g=tempSp_g*2/3;
                    tempSp_a=tempSp_a*2/3;
                    tempDps_g=T_dmg_g[current]*T_atks_g[current]/tempSp_g;
                    tempDps_a=T_dmg_a[current]*T_atks_a[current]/tempSp_a;

                    atkSp_g.setText(Double.toString(  (Math.round(tempSp_g*100))*0.01));
                    atkSp_a.setText(Double.toString(  (Math.round(tempSp_a*100))*0.01));
                     dps_g.setText(Double.toString(  (Math.round(tempDps_g*100))*0.01));
                    dps_a.setText(Double.toString(  (Math.round(tempDps_a*100))*0.01));
                    move.setText("4.73");

                }else if(current==9 && turret==true){
                   // dmg_g.setText("23");
                    //dmg_a.setText("23");
                    //dps_g.setText("40.35");
                    //dps_a.setText("40.35");
                }

            }
        });

        upgrade3=(ImageButton)findViewById(R.id.imageButton_upgrade3);
        upgrade3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){


            }
        });

        skill1=(ImageButton)findViewById(R.id.imageButton_skill1);
        skill1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                hellbatOFF=true;
                if(current==5) {  //hellbat-motor mode
                    hp.setText("90");
                    type.setText("Light-Mec");
                    range_a.setText("0");
                    range_g.setText("5");
                    move.setText("5.95");
                    dmg_a.setText("0");
                    dmg_g.setText("8");
                    atkSp_g.setText("1.79");
                    atkSp_a.setText("0");
                    dps_g.setText("4.47");
                    dps_a.setText("0");
                    bouns.setText("Gnd-Lig+6");
                }else if(current == 7){// viking_assault
                    hp.setText("125");

                    type.setText("Armored-Mec");
                    range_a.setText("0");
                    range_g.setText("6");
                    move.setText("3.15");
                    dmg_a.setText("0");
                    dmg_g.setText("12");
                    atkSp_g.setText("0.71");
                    atkSp_a.setText("0");
                    dps_g.setText("16.9");
                    dps_a.setText("0");
                    bouns.setText("Mec+8");
                }else if(current == 9){// Raven turret
                    turret=true;
                    hp.setText("150");
                    armor.setText("1+2");
                    type.setText("Armored-Mec-Strc");
                    range_a.setText("6");
                    range_g.setText("6");
                    move.setText("0");


                        dmg_g.setText("18");
                        dmg_a.setText("18");
                        dps_g.setText("31.57");
                        dps_a.setText("31.57");

                    atkSp_g.setText("0.57");
                    atkSp_a.setText("0.57");

                    bouns.setText("N/A");
                }else if(current == 10){// tank siege

                    hp.setText("175");
                    armor.setText("1");
                    type.setText("Armored-Mec");
                    range_a.setText("0");
                    range_g.setText("13");
                    move.setText("0");


                    dmg_g.setText("40");
                    dmg_a.setText("0");
                    dps_g.setText("18.78");
                    dps_a.setText("0");

                    atkSp_g.setText("2.13");
                    atkSp_a.setText("0");

                    bouns.setText("Gnd-Arm+30");
                }else if(current == 13){// thor HIP

                    hp.setText("400");
                    armor.setText("2");
                    type.setText("Armored-Mec");
                    range_a.setText("10");
                    range_g.setText("7");
                    move.setText("2.62");


                    dmg_g.setText("30x2");
                    dmg_a.setText("35");
                    dps_g.setText("18.78");
                    dps_a.setText("16.3");

                    atkSp_g.setText("0.91");
                    atkSp_a.setText("2.14");

                    bouns.setText("Air-Arm+15");
                }else if(current == 15){// lib_def mode
                    lib_defON=true;

                    hp.setText("180");
                    armor.setText("1");
                    type.setText("Armored-Mec");
                    range_a.setText("0");
                    range_g.setText("5");
                    move.setText("4.72");


                    dmg_g.setText("75");
                    dmg_a.setText("0");
                    dps_g.setText("65.8");
                    dps_a.setText("0");

                    atkSp_g.setText("1.14");
                    atkSp_a.setText("0");

                    bouns.setText("N/A");
                }
            }
        });

        skill2=(ImageButton)findViewById(R.id.imageButton_skill2);
        skill2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(current==6){
                    move.setText("5.95");
                }


            }
        });

        skill3=(ImageButton)findViewById(R.id.imageButton_skill3);
        skill3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){


            }
        });







        //Terran units
        /////////////////////////////////////COST
        T_marine=(ImageButton)findViewById(R.id.imageButton1);
        T_marine.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int i=1;
                current=i;
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



                //--------------------------------------------upgrade control--------------------------------
                upgrade1.setImageResource(R.drawable.marrine_shield);
                upgrade2.setImageResource(R.drawable.marine_stimpack);
                //upgrade3.setImageResource(R.drawable.);
                //skill1.setImageResource(R.drawable.);
                //skill2.setImageResource(R.drawable.);
                //skill3.setImageResource(R.drawable.);

                upgrade1.setVisibility(View.VISIBLE);  //One of VISIBLE, INVISIBLE, or GONE.
                upgrade2.setVisibility(View.VISIBLE);
                upgrade3.setVisibility(View.INVISIBLE);
                skill1.setVisibility(View.INVISIBLE);
                skill2.setVisibility(View.INVISIBLE);
                skill3.setVisibility(View.INVISIBLE);

            }
        });

        T_marauder=(ImageButton)findViewById(R.id.imageButton2);
        T_marauder.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int i=2;current=i;
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


                //--------------------------------------------upgrade control--------------------------------

                upgrade2.setImageResource(R.drawable.marine_stimpack);
                upgrade1.setImageResource(R.drawable.marauder_shells);
                upgrade1.setVisibility(View.VISIBLE);  //One of VISIBLE, INVISIBLE, or GONE.
                upgrade2.setVisibility(View.VISIBLE);
                upgrade3.setVisibility(View.INVISIBLE);
                skill1.setVisibility(View.INVISIBLE);
                skill2.setVisibility(View.INVISIBLE);
                skill3.setVisibility(View.INVISIBLE);

            }
        });

        T_reaper=(ImageButton)findViewById(R.id.imageButton3);
        T_reaper.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int i=3;current=i;
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

//--------------------------------------------upgrade control--------------------------------

                //upgrade1.setImageResource(R.drawable.marrine_shield);
                //upgrade2.setImageResource(R.drawable.marine_stimpack);
                //upgrade3.setImageResource(R.drawable.);
                skill1.setImageResource(R.drawable.reaper_durg);
                //skill2.setImageResource(R.drawable.);
                //skill3.setImageResource(R.drawable.);

                upgrade1.setVisibility(View.INVISIBLE);  //One of VISIBLE, INVISIBLE, or GONE.
                upgrade2.setVisibility(View.INVISIBLE);
                upgrade3.setVisibility(View.INVISIBLE);
                skill1.setVisibility(View.VISIBLE);
                skill2.setVisibility(View.INVISIBLE);
                skill3.setVisibility(View.INVISIBLE);
            }
        });

        T_ghost=(ImageButton)findViewById(R.id.imageButton4);
        T_ghost.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int i=4;current=i;
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
//--------------------------------------------upgrade control--------------------------------

                upgrade1.setImageResource(R.drawable.ghost_cloak);
                //upgrade2.setImageResource(R.drawable.marine_stimpack);
                //upgrade3.setImageResource(R.drawable.);
                skill1.setImageResource(R.drawable.ghost_snipe);
                skill2.setImageResource(R.drawable.ghost_emp);
                skill3.setImageResource(R.drawable.ghost_cloak);

                upgrade1.setVisibility(View.VISIBLE);  //One of VISIBLE, INVISIBLE, or GONE.
                upgrade2.setVisibility(View.INVISIBLE);
                upgrade3.setVisibility(View.INVISIBLE);
                skill1.setVisibility(View.VISIBLE);
                skill2.setVisibility(View.VISIBLE);
                skill3.setVisibility(View.VISIBLE);

            }
        });

        T_hellBat=(ImageButton)findViewById(R.id.imageButton5);
        T_hellBat.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int i=5;current=i;
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
//--------------------------------------------upgrade control--------------------------------
                hellbatOFF=false;
                upgrade1.setImageResource(R.drawable.hellbat_bluef);
                //upgrade2.setImageResource(R.drawable.marine_stimpack);
                //upgrade3.setImageResource(R.drawable.);
                skill1.setImageResource(R.drawable.hellbat_hellion);
                //skill2.setImageResource(R.drawable.ghost_emp);
                //skill3.setImageResource(R.drawable.ghost_cloak);

                upgrade1.setVisibility(View.VISIBLE);  //One of VISIBLE, INVISIBLE, or GONE.
                upgrade2.setVisibility(View.INVISIBLE);
                upgrade3.setVisibility(View.INVISIBLE);
                skill1.setVisibility(View.VISIBLE);
                skill2.setVisibility(View.INVISIBLE);
                skill3.setVisibility(View.INVISIBLE);

            }
        });

        T_medivac=(ImageButton)findViewById(R.id.imageButton6);
        T_medivac.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int i=6;current=i;
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
                //--------------------------------------------upgrade control--------------------------------
                //upgrade1.setImageResource(R.drawable.hellbat_bluef);
                //upgrade2.setImageResource(R.drawable.marine_stimpack);
                //upgrade3.setImageResource(R.drawable.);
                skill1.setImageResource(R.drawable.medivac_heal);
                skill2.setImageResource(R.drawable.medivac_afterburner);
                //skill3.setImageResource(R.drawable.ghost_cloak);

                upgrade1.setVisibility(View.INVISIBLE);  //One of VISIBLE, INVISIBLE, or GONE.
                upgrade2.setVisibility(View.INVISIBLE);
                upgrade3.setVisibility(View.INVISIBLE);
                skill1.setVisibility(View.VISIBLE);
                skill2.setVisibility(View.VISIBLE);
                skill3.setVisibility(View.INVISIBLE);


            }
        });

        T_viking=(ImageButton)findViewById(R.id.imageButton7);
        T_viking.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int i=7;current=i;
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
//--------------------------------------------upgrade control--------------------------------
                //upgrade1.setImageResource(R.drawable.hellbat_bluef);
                //upgrade2.setImageResource(R.drawable.marine_stimpack);
                //upgrade3.setImageResource(R.drawable.);
                skill1.setImageResource(R.drawable.viking_assault);
                //skill2.setImageResource(R.drawable.medivac_afterburner);
                //skill3.setImageResource(R.drawable.ghost_cloak);

                upgrade1.setVisibility(View.INVISIBLE);  //One of VISIBLE, INVISIBLE, or GONE.
                upgrade2.setVisibility(View.INVISIBLE);
                upgrade3.setVisibility(View.INVISIBLE);
                skill1.setVisibility(View.VISIBLE);
                skill2.setVisibility(View.INVISIBLE);
                skill3.setVisibility(View.INVISIBLE);
            }
        });

        T_banshee=(ImageButton)findViewById(R.id.imageButton8);
        T_banshee.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int i=8;current=i;
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
//--------------------------------------------upgrade control--------------------------------
                //upgrade1.setImageResource(R.drawable.hellbat_bluef);
                //upgrade2.setImageResource(R.drawable.marine_stimpack);
                //upgrade3.setImageResource(R.drawable.);
                skill1.setImageResource(R.drawable.ghost_cloak);
                //skill2.setImageResource(R.drawable.medivac_afterburner);
                //skill3.setImageResource(R.drawable.ghost_cloak);

                upgrade1.setVisibility(View.INVISIBLE);  //One of VISIBLE, INVISIBLE, or GONE.
                upgrade2.setVisibility(View.INVISIBLE);
                upgrade3.setVisibility(View.INVISIBLE);
                skill1.setVisibility(View.VISIBLE);
                skill2.setVisibility(View.INVISIBLE);
                skill3.setVisibility(View.INVISIBLE);

            }
        });

        T_raven=(ImageButton)findViewById(R.id.imageButton9);
        T_raven.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int i=9;current=i;
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
                //--------------------------------------------upgrade control--------------------------------
                turret=false;
                upgrade1.setImageResource(R.drawable.raven_reactor);
                upgrade2.setImageResource(R.drawable.raven_shells);
                //upgrade3.setImageResource(R.drawable.);
                skill1.setImageResource(R.drawable.raven_turret);
                skill2.setImageResource(R.drawable.raven_drone);
                skill3.setImageResource(R.drawable.raven_missile);

                upgrade1.setVisibility(View.VISIBLE);  //One of VISIBLE, INVISIBLE, or GONE.
                upgrade2.setVisibility(View.VISIBLE);
                upgrade3.setVisibility(View.INVISIBLE);
                skill1.setVisibility(View.VISIBLE);
                skill2.setVisibility(View.VISIBLE);
                skill3.setVisibility(View.VISIBLE);

            }
        });

        T_tank=(ImageButton)findViewById(R.id.imageButton10);
        T_tank.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int i=10;current=i;
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

                //--------------------------------------------upgrade control--------------------------------

                //upgrade1.setImageResource(R.drawable.raven_reactor);
               // upgrade2.setImageResource(R.drawable.raven_shells);
                //upgrade3.setImageResource(R.drawable.);
                skill1.setImageResource(R.drawable.tank_siege);
                //skill2.setImageResource(R.drawable.raven_drone);
               // skill3.setImageResource(R.drawable.raven_missile);

                upgrade1.setVisibility(View.INVISIBLE);  //One of VISIBLE, INVISIBLE, or GONE.
                upgrade2.setVisibility(View.INVISIBLE);
                upgrade3.setVisibility(View.INVISIBLE);
                skill1.setVisibility(View.VISIBLE);
                skill2.setVisibility(View.INVISIBLE);
                skill3.setVisibility(View.INVISIBLE);

            }
        });

        T_mine=(ImageButton)findViewById(R.id.imageButton11);
        T_mine.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int i=11;current=i;
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
//--------------------------------------------upgrade control--------------------------------

                //upgrade1.setImageResource(R.drawable.raven_reactor);
                // upgrade2.setImageResource(R.drawable.raven_shells);
                //upgrade3.setImageResource(R.drawable.);
                skill1.setImageResource(R.drawable.mine_active);
                skill2.setImageResource(R.drawable.mine_missile);
                // skill3.setImageResource(R.drawable.raven_missile);

                upgrade1.setVisibility(View.INVISIBLE);  //One of VISIBLE, INVISIBLE, or GONE.
                upgrade2.setVisibility(View.INVISIBLE);
                upgrade3.setVisibility(View.INVISIBLE);
                skill1.setVisibility(View.VISIBLE);
                skill2.setVisibility(View.VISIBLE);
                skill3.setVisibility(View.INVISIBLE);


            }
        });

        T_cyclone=(ImageButton)findViewById(R.id.imageButton12);
        T_cyclone.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int i=12;current=i;
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
//--------------------------------------------upgrade control--------------------------------

                //upgrade1.setImageResource(R.drawable.raven_reactor);
                // upgrade2.setImageResource(R.drawable.raven_shells);
                //upgrade3.setImageResource(R.drawable.);
                skill1.setImageResource(R.drawable.cyclone_lockon);
               // skill2.setImageResource(R.drawable.mine_missile);
                // skill3.setImageResource(R.drawable.raven_missile);

                upgrade1.setVisibility(View.INVISIBLE);  //One of VISIBLE, INVISIBLE, or GONE.
                upgrade2.setVisibility(View.INVISIBLE);
                upgrade3.setVisibility(View.INVISIBLE);
                skill1.setVisibility(View.VISIBLE);
                skill2.setVisibility(View.INVISIBLE);
                skill3.setVisibility(View.INVISIBLE);

            }
        });

        T_thor=(ImageButton)findViewById(R.id.imageButton13);
        T_thor.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int i=13;current=i;
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
                //--------------------------------------------upgrade control--------------------------------

                //upgrade1.setImageResource(R.drawable.raven_reactor);
                // upgrade2.setImageResource(R.drawable.raven_shells);
                //upgrade3.setImageResource(R.drawable.);
                skill1.setImageResource(R.drawable.thor_hmode);
                // skill2.setImageResource(R.drawable.mine_missile);
                // skill3.setImageResource(R.drawable.raven_missile);

                upgrade1.setVisibility(View.INVISIBLE);  //One of VISIBLE, INVISIBLE, or GONE.
                upgrade2.setVisibility(View.INVISIBLE);
                upgrade3.setVisibility(View.INVISIBLE);
                skill1.setVisibility(View.VISIBLE);
                skill2.setVisibility(View.INVISIBLE);
                skill3.setVisibility(View.INVISIBLE);



            }
        });

        T_BC=(ImageButton)findViewById(R.id.imageButton14);
        T_BC.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int i=14;current=i;
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
                //--------------------------------------------upgrade control--------------------------------

                upgrade1.setImageResource(R.drawable.bc_yamato);
                // upgrade2.setImageResource(R.drawable.raven_shells);
                //upgrade3.setImageResource(R.drawable.);
                skill1.setImageResource(R.drawable.bc_yamato);
                 skill2.setImageResource(R.drawable.bc_warp);
                // skill3.setImageResource(R.drawable.raven_missile);

                upgrade1.setVisibility(View.VISIBLE);  //One of VISIBLE, INVISIBLE, or GONE.
                upgrade2.setVisibility(View.INVISIBLE);
                upgrade3.setVisibility(View.INVISIBLE);
                skill1.setVisibility(View.VISIBLE);
                skill2.setVisibility(View.VISIBLE);
                skill3.setVisibility(View.INVISIBLE);


            }
        });

        T_lib=(ImageButton)findViewById(R.id.imageButton15);
        T_lib.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int i=15;current=i;
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
                //--------------------------------------------upgrade control--------------------------------
                lib_defON=false;

                upgrade1.setImageResource(R.drawable.lib_adv);
                // upgrade2.setImageResource(R.drawable.raven_shells);
                //upgrade3.setImageResource(R.drawable.);
                skill1.setImageResource(R.drawable.lib_defmode);
                //skill2.setImageResource(R.drawable.BC_warp);
                // skill3.setImageResource(R.drawable.raven_missile);

                upgrade1.setVisibility(View.VISIBLE);  //One of VISIBLE, INVISIBLE, or GONE.
                upgrade2.setVisibility(View.INVISIBLE);
                upgrade3.setVisibility(View.INVISIBLE);
                skill1.setVisibility(View.VISIBLE);
                skill2.setVisibility(View.INVISIBLE);
                skill3.setVisibility(View.INVISIBLE);

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
        else if(input%10==7)
            s=s+"Mec-Bio";
        return s;
    }
}
