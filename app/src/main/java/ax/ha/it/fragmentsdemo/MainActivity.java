package ax.ha.it.fragmentsdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import ax.ha.it.fragmentsdemo.databinding.ActivityMainBinding;
import ax.ha.it.fragmentsdemo.AdvicesService;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private RetrofitInstance RetrofitClientInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FragmentManager fragmentManager = getSupportFragmentManager();
        NavHostFragment navHostFragment = (NavHostFragment) fragmentManager.findFragmentById(R.id.nav_host_fragment);
        assert navHostFragment != null;
        NavController navController = navHostFragment.getNavController();
        BottomNavigationView bottomNav = findViewById(R.id.nav_bottom_fragment);
        NavigationUI.setupWithNavController(bottomNav, navController);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.advices, R.id.addAdvices, R.id.settings).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

    }
}
