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
                        mtab_start_activity_LL,mtab_start_home_LL,versionLayout
                        ,userNameLayout,editProfileLayout,assignmentLayout,
                        scheduleLayout,changeAvatarLayout,registeredDevicesLayout,
                        bookmarkLayout,recentActivityLayout,notificationSettingLayout,savedDraftLayout,boostLayout;
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
        assignmentLayout = findViewById(R.id.assignment);
        scheduleLayout = findViewById(R.id.schedule_layout);
        changeAvatarLayout = findViewById(R.id.change_avatar_layout);
        registeredDevicesLayout = findViewById(R.id.registered_devices_layout);
        bookmarkLayout = findViewById(R.id.bookmark_layout);
        recentActivityLayout = findViewById(R.id.recent_activity_layout);
        notificationSettingLayout = findViewById(R.id.notification_setting_layout);
        savedDraftLayout = findViewById(R.id.saved_draft_layout);
        boostLayout = findViewById(R.id.boost_layout);

        mcv_search_expand.setOnClickListener(this);
        mtab_start_hey_LL=(LinearLayout)findViewById(R.id.tab_start_hey_LL);
        mtab_start_home_LL=(LinearLayout)findViewById(R.id.tab_start_home_LL);
        mtab_start_activity_LL=(LinearLayout)findViewById(R.id.tab_start_activity_LL);

        boostLayout.setOnClickListener(this);
        savedDraftLayout.setOnClickListener(this);
        notificationSettingLayout.setOnClickListener(this);
        recentActivityLayout.setOnClickListener(this);
        bookmarkLayout.setOnClickListener(this);
        registeredDevicesLayout.setOnClickListener(this);
        changeAvatarLayout.setOnClickListener(this);
        scheduleLayout.setOnClickListener(this);
        assignmentLayout.setOnClickListener(this);
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

            case R.id.assignment:
                Intent intent1 = new Intent(this,MyAssignmentActivity.class);
                startActivity(intent1);
                break;

            case R.id.schedule_layout:
                Intent intent2 = new Intent(this,ScheduleActivity.class);
                startActivity(intent2);
                break;

            case R.id.change_avatar_layout:
                Intent intent3 = new Intent(this,ChangeAvatarActivity.class);
                startActivity(intent3);
                break;

            case R.id.registered_devices_layout:
                Intent intent4 = new Intent(this,MyDevicesActivity.class);
                startActivity(intent4);
                break;

            case R.id.bookmark_layout:
                Intent intent5 = new Intent(this,BookmarkActivity.class);
                startActivity(intent5);
                break;

            case R.id.recent_activity_layout:
                Intent intent6 = new Intent(this,RecentActivity.class);
                startActivity(intent6);
                break;

            case R.id.notification_setting_layout:
                Intent intent7 = new Intent(this,NotificationSettingActivity.class);
                startActivity(intent7);
                break;

            case R.id.saved_draft_layout:
                Intent intent8 = new Intent(this,SavedDraftActivity.class);
                startActivity(intent8);
                break;

            case R.id.boost_layout:
                Intent intent9 = new Intent(this,BoostActivity.class);
                startActivity(intent9);
                break;
        }
    }
}
