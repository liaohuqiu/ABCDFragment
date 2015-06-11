package demos.srain.in.abcdfragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        FragmentA fragment = new FragmentA();
        transaction.add(R.id.id_fragment_a, fragment, "FragmentA");
        transaction.commit();
    }
}

