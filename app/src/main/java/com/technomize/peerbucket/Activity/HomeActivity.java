package com.technomize.peerbucket.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
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
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.technomize.peerbucket.R;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    CardView mcv_company_hq, mcv_search_expand;
    LinearLayout mcreate_team_LL,mcreate_new_project_LL,mtab_start_hey_LL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mcv_company_hq=(CardView)findViewById(R.id.cv_company_hq);
        mcv_search_expand=(CardView)findViewById(R.id.cv_search_expand);
        mcreate_team_LL=(LinearLayout)findViewById(R.id.create_team_LL);
        mcreate_new_project_LL=(LinearLayout)findViewById(R.id.create_new_project_LL);
        mtab_start_hey_LL=(LinearLayout)findViewById(R.id.tab_start_hey_LL);

        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setExpandedTitleTextAppearance(R.style.collapsingToolbarLayoutTitleColor);
        collapsingToolbar.setCollapsedTitleTextAppearance(R.style.collapsingToolbarLayoutTitleColor);



        mcv_company_hq.setOnClickListener(this);
        mcv_search_expand.setOnClickListener(this);
        mcreate_team_LL.setOnClickListener(this);
        mcreate_new_project_LL.setOnClickListener(this);
        mtab_start_hey_LL.setOnClickListener(this);
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
/*
                mcv_search_expand.setVisibility(View.VISIBLE);
*/
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
                final AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();
                break;
            case R.id.create_team_LL:
                final Dialog dialog = new Dialog(this, android.R.style.Theme_Light);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

                dialog.setContentView(R.layout.dialog_create_tcp);
                dialog.show();
                TextView mheader_tcp_dialog_tv=(TextView) dialog.findViewById(R.id.header_tcp_dialog_tv);
                TextView mtcp_name_header_tv=(TextView) dialog.findViewById(R.id.tcp_name_header_tv);
                EditText mtcp_name_et=(EditText) dialog.findViewById(R.id.tcp_name_et);
                TextView moptional_desc_tv=(TextView) dialog.findViewById(R.id.optional_desc_tv);
                EditText moptional_desc_et=(EditText) dialog.findViewById(R.id.optional_desc_et);
                mheader_tcp_dialog_tv.setText(R.string.tcp_dialog_header);
                ImageView mclose_tcp_dialog_iv=(ImageView) dialog.findViewById(R.id.close_tcp_dialog_iv);
                mclose_tcp_dialog_iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.create_new_project_LL:
                final Dialog dialog_np = new Dialog(this, android.R.style.Theme_Light);
                dialog_np.requestWindowFeature(Window.FEATURE_NO_TITLE);

                dialog_np.setContentView(R.layout.dialog_create_tcp);
                dialog_np.show();
                mheader_tcp_dialog_tv = (TextView) dialog_np.findViewById(R.id.header_tcp_dialog_tv);
                mtcp_name_header_tv=(TextView) dialog_np.findViewById(R.id.tcp_name_header_tv);
                mtcp_name_et=(EditText) dialog_np.findViewById(R.id.tcp_name_et);
                moptional_desc_tv=(TextView) dialog_np.findViewById(R.id.optional_desc_tv);
                moptional_desc_et=(EditText) dialog_np.findViewById(R.id.optional_desc_et);
                moptional_desc_et.setHint(R.string.eg_optional_project_desc);
                moptional_desc_tv.setText(R.string.optional_desc);
                mtcp_name_et.setHint(R.string.eg_project_name);
                mtcp_name_header_tv.setText(R.string.project_create_name);
                mheader_tcp_dialog_tv.setText(R.string.tcp_project_dialog_header);
                 mclose_tcp_dialog_iv=(ImageView) dialog_np.findViewById(R.id.close_tcp_dialog_iv);
                mclose_tcp_dialog_iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog_np.dismiss();
                    }
                });
                break;
            case R.id.tab_start_hey_LL:
                Intent startHeyActivity= new Intent(HomeActivity.this,HeyActivity.class);
                startActivity(startHeyActivity);
                finish();
                break;
        }
    }
}
