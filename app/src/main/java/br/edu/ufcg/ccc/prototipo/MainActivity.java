package br.edu.ufcg.ccc.prototipo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            AtividadeFragment atividadeFragment = new AtividadeFragment();

            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.layoutFrag, atividadeFragment);
            ft.commit();
        }


        FloatingActionButton button = (FloatingActionButton) findViewById(R.id.fab);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTitle(R.string.novaTi);
                CriarTIFragment frag = new CriarTIFragment();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.layoutFrag, frag, "criar_ti");

                ft.commit();
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_atividades) {
            setTitle(R.string.atividades);
            AtividadeFragment atividadeFragment = new AtividadeFragment();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.layoutFrag, atividadeFragment, "atividadeFragment");

            ft.commit();
            // TODO
        } else if (id == R.id.nav_historico) {
            setTitle(R.string.historico);
            HistoricoFragment historicoFragment = new HistoricoFragment();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.layoutFrag, historicoFragment, "historicoFragment");

            ft.commit();
            // TODO
        } else if (id == R.id.nav_acompanhamento) {
            setTitle(R.string.acompanhamento);

            AcompanhamentoFragment frag = new AcompanhamentoFragment();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.layoutFrag, frag, "acompanhamentofragment");

            ft.commit();
            // TODO
        } else if (id == R.id.nav_sobre) {
            setTitle(R.string.sobre);
            // TODO
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
