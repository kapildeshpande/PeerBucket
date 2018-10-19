package com.technomize.peerbucket.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.technomize.peerbucket.R;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener,
        AdapterView.OnItemSelectedListener {

    CardView mcv_company_hq, mcv_search_expand,fabLayout;
    LinearLayout mcreate_team_LL,mcreate_new_project_LL
            ,mtab_start_hey_LL,closeFabLayout,mtab_start_activity_LL,mtab_start_me_LL,
            mdialog_tcp_chat,mdialog_tcp_message_board,mdialog_tcp_automatic_checkins,mdialog_tcp_docs_and_files,
            mdialog_tcp_todos,mdialog_tcp_schedule;
    FloatingActionButton floatingActionButton;
    Spinner mtoolbar_spinner;
    String[] accounts = { "Testing Acoount", "Check 1", "No Check", "That's it", "Done"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mtoolbar_spinner=(Spinner)toolbar.findViewById(R.id.toolbar_spinner);
        mcv_company_hq=(CardView)findViewById(R.id.cv_company_hq);
        mcv_search_expand=(CardView)findViewById(R.id.cv_search_expand);
        mcreate_team_LL=(LinearLayout)findViewById(R.id.create_team_LL);
        mcreate_new_project_LL=(LinearLayout)findViewById(R.id.create_new_project_LL);
        mtab_start_hey_LL=(LinearLayout)findViewById(R.id.tab_start_hey_LL);
        mtab_start_me_LL=(LinearLayout)findViewById(R.id.tab_start_me_LL);


        mtab_start_activity_LL = findViewById(R.id.tab_start_activity_LL);

        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setExpandedTitleTextAppearance(R.style.collapsingToolbarLayoutTitleColor);
        collapsingToolbar.setCollapsedTitleTextAppearance(R.style.collapsingToolbarLayoutTitleColor);

        fabLayout = findViewById(R.id.fab_layout);
        closeFabLayout = findViewById(R.id.close_fab_layout);

        floatingActionButton = findViewById(R.id.fab);

        closeFabLayout.setOnClickListener(this);
        floatingActionButton.setOnClickListener(this);
        mcv_company_hq.setOnClickListener(this);
        mcv_search_expand.setOnClickListener(this);
        mcreate_team_LL.setOnClickListener(this);
        mcreate_new_project_LL.setOnClickListener(this);
        mtab_start_hey_LL.setOnClickListener(this);
        mtab_start_activity_LL.setOnClickListener(this);
        mtab_start_me_LL.setOnClickListener(this);
        mtoolbar_spinner.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this,R.layout.custom_spinner,accounts);
        aa.setDropDownViewResource(R.layout.custom_spinner_dropdown);

        //Setting the ArrayAdapter data on the Spinner
        mtoolbar_spinner.setAdapter(aa);

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
            case R.id.cv_company_hq:
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);

                LayoutInflater inflater = this.getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.dialog_tcp_expand, null);
                dialogBuilder.setView(dialogView);

                ImageView imageView = dialogView.findViewById(R.id.expand_company_hq);
                TextView textView = dialogView.findViewById(R.id.add_remove);

                mdialog_tcp_chat=(LinearLayout) dialogView.findViewById(R.id.dialog_tcp_chat);
                mdialog_tcp_message_board=(LinearLayout) dialogView.findViewById(R.id.dialog_tcp_message_board);
                mdialog_tcp_automatic_checkins=(LinearLayout) dialogView.findViewById(R.id.dialog_tcp_automatic_checkins);
                mdialog_tcp_docs_and_files=(LinearLayout) dialogView.findViewById(R.id.dialog_tcp_docs_and_files);
                mdialog_tcp_todos=(LinearLayout) dialogView.findViewById(R.id.dialog_tcp_todos);
                mdialog_tcp_schedule=(LinearLayout) dialogView.findViewById(R.id.dialog_tcp_schedule);

                final AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();

                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(HomeActivity.this,AddRemovePeopleActivity.class);
                        startActivity(intent);
                    }
                });


                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(HomeActivity.this,CompanyHQExpandActivity.class);
                        startActivity(intent);
                    }
                });

                mdialog_tcp_chat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(HomeActivity.this,ChatActivity.class);
                        startActivity(intent);
                    }
                });

                mdialog_tcp_message_board.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(HomeActivity.this,Activity_MessageBoard.class);
                        startActivity(intent);
                    }
                });

                mdialog_tcp_automatic_checkins.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(HomeActivity.this,AutomaticCheckinActivity.class);
                        startActivity(intent);
                    }
                });

                mdialog_tcp_docs_and_files.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(HomeActivity.this,DocsAndFilesActivity.class);
                        startActivity(intent);
                    }
                });

                mdialog_tcp_todos.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(HomeActivity.this,ToDoActivity.class);
                        startActivity(intent);
                    }
                });

                mdialog_tcp_schedule.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(HomeActivity.this,ScheduleActivity.class);
                        startActivity(intent);
                    }
                });

                break;
            case R.id.create_team_LL:
                Intent intentnewT= new Intent(HomeActivity.this,CreateTeamActivity.class);
                startActivity(intentnewT);
                break;
            case R.id.create_new_project_LL:
                Intent intentnewP= new Intent(HomeActivity.this,CreateProjectActivity.class);
                startActivity(intentnewP);
                break;
            case R.id.tab_start_hey_LL:
                Intent startHeyActivity= new Intent(HomeActivity.this,HeyActivity.class);
                startActivity(startHeyActivity);
                finish();
                break;

            case R.id.tab_start_activity_LL:
                Intent activity = new Intent(HomeActivity.this,ActivityScreen.class);
                startActivity(activity);
                finish();
                break;

            case R.id.tab_start_me_LL:
                Intent activity1 = new Intent(HomeActivity.this,MeActivity.class);
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
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(),accounts[position] , Toast.LENGTH_LONG).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }
}
