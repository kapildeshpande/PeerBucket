package com.technomize.peerbucket.Activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.technomize.peerbucket.R;

public class MeActivity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton floatingActionButton;
    private LinearLayout mtab_start_hey_LL,closeFabLayout,
                        mtab_start_activity_LL,mtab_start_home_LL,versionLayout,userNameLayout,editProfileLayout;
    private CardView fabLayout, mcv_search_expand;
    private Typeface fontTF,fontTFRegular;
    private TextView bookmark,schedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);

        initToolbar();
        initUI();
    }

    private void initUI () {

        floatingActionButton = findViewById(R.id.fab);
        fabLayout = findViewById(R.id.fab_layout);
        closeFabLayout = findViewById(R.id.close_fab_layout);
        mcv_search_expand=(CardView)findViewById(R.id.cv_search_expand);
        versionLayout = findViewById(R.id.version);
        userNameLayout = findViewById(R.id.user_name);
        bookmark = findViewById(R.id.bookmark);
        schedule = findViewById(R.id.schedule);
        editProfileLayout = findViewById(R.id.edit_profile);

        mcv_search_expand.setOnClickListener(this);
        mtab_start_hey_LL=(LinearLayout)findViewById(R.id.tab_start_hey_LL);
        mtab_start_home_LL=(LinearLayout)findViewById(R.id.tab_start_home_LL);
        mtab_start_activity_LL=(LinearLayout)findViewById(R.id.tab_start_activity_LL);

        editProfileLayout.setOnClickListener(this);
        schedule.setOnClickListener(this);
        bookmark.setOnClickListener(this);
        userNameLayout.setOnClickListener(this);
        versionLayout.setOnClickListener(this);
        closeFabLayout.setOnClickListener(this);
        floatingActionButton.setOnClickListener(this);
        mtab_start_hey_LL.setOnClickListener(this);
        mtab_start_activity_LL.setOnClickListener(this);
        mtab_start_home_LL.setOnClickListener(this);

        //Font Awesome
//        fontTF= Typeface.createFromAsset(getAssets(), "font/fawsmsolid.ttf");
//        fontTFRegular = Typeface.createFromAsset(getAssets(),"font/fawsmsolid.tft");
//        bookmark.setTypeface(fontTF);
//        bookmark.setText("\uF02E");
//
//        schedule.setTypeface(fontTFRegular);
//        schedule.setText("\uF073");
    }

    private void initToolbar () {

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setExpandedTitleTextAppearance(R.style.collapsingToolbarLayoutTitleColor);
        collapsingToolbar.setCollapsedTitleTextAppearance(R.style.collapsingToolbarLayoutTitleColor);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.search:
                mcv_search_expand.setVisibility(View.VISIBLE);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tab_start_hey_LL:
                Intent startHeyActivity= new Intent(this,HeyActivity.class);
                startActivity(startHeyActivity);
                finish();
                break;

            case R.id.tab_start_activity_LL:
                Intent activity = new Intent(this,ActivityScreen.class);
                startActivity(activity);
                finish();
                break;

            case R.id.tab_start_home_LL:
                Intent activity1 = new Intent(this,HomeActivity.class);
                startActivity(activity1);
                finish();
                break;

            case R.id.fab:
                floatingActionButton.setVisibility(View.GONE);
                fabLayout.setVisibility(View.VISIBLE);
                break;

            case R.id.close_fab_layout:
                fabLayout.setVisibility(View.GONE);
                floatingActionButton.setVisibility(View.VISIBLE);
                break;

            case R.id.edit_profile:
                Intent intent = new Intent(this,EditProfileActivity.class);
                startActivity(intent);
                break;

            case R.id.version:
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);

                LayoutInflater inflater = this.getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.dialog_version, null);
                dialogBuilder.setView(dialogView);

                TextView mDialogCancel = (TextView) dialogView.findViewById(R.id.textview_close);

                final AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();
                mDialogCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                break;

            case R.id.user_name:
                AlertDialog.Builder dialogBuilder1 = new AlertDialog.Builder(this);

                LayoutInflater inflater1 = this.getLayoutInflater();
                View dialogView1 = inflater1.inflate(R.layout.dialog_profile, null);
                dialogBuilder1.setView(dialogView1);

                final AlertDialog alertDialog1 = dialogBuilder1.create();
                alertDialog1.show();
                break;
        }
    }
}
