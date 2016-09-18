package drd.flhspatriotbattalion;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
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
    public FloatingActionButton FAB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CentralFragment centralFragment = new CentralFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                centralFragment,
                centralFragment.getTag()).commit();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Francis Lewis");
        getSupportActionBar().setSubtitle("Patroits");
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_help) {
            Help help = new Help();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                    help,
                    help.getTag()).commit();
            return true;
        }else if (id == R.id.action_create){
            Create_Fragment create_fragment= new Create_Fragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                    create_fragment,
                    create_fragment.getTag()).commit();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.Home){
            CentralFragment centralFragment = new CentralFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                    centralFragment,
                    centralFragment.getTag()).commit();
            System.out.println("Home Selected");
        }
        else if (id == R.id.Alpha) {
            AlphaFragment alphaFragment = new AlphaFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                alphaFragment,
                alphaFragment.getTag()).commit();
            // Handle the camera action
            System.out.println(
                    "Alpha Selected"
            );
        } else if (id == R.id.Bravo) {
            BravoFragment bravoFragment = new BravoFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                    bravoFragment,
                    bravoFragment.getTag()).commit();

        } else if (id == R.id.Charlie) {

        } else if (id == R.id.Echo) {

        } else if (id == R.id.Knowledge_grooming) {
        Grooming grooming = new Grooming();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                    grooming,
                    grooming.getTag()).commit();
        } else if (id == R.id.Knowledge_sheet) {
            Knowledge_sheet knowledge_sheet = new Knowledge_sheet();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                    knowledge_sheet,
                   knowledge_sheet.getTag()).commit();
        }else if (id== R.id.Knowledge_Ranks_Ribbons){
                RanksAndRibbions ranksAndRibbions  = new RanksAndRibbions();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                    ranksAndRibbions,
                    ranksAndRibbions.getTag()).commit();
        }else if(id == R.id.Knowledge_Uniform){
            uniform Uniform = new uniform();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                    Uniform,
                    Uniform.getTag()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
