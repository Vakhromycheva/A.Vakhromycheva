package com.example.dz1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements NechetNumberClick{
    private NechetNumberFragment NechetNumberFragment;
    private ChetNumberFragment ChetNumberFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        NechetNumberFragment = (NechetNumberFragment) getSupportFragmentManager().findFragmentByTag(NechetNumberFragment.TAG);
        ChetNumberFragment = (ChetNumberFragment) getSupportFragmentManager().findFragmentByTag(ChetNumberFragment.TAG);

        if (NechetNumberFragment == null) {
            NechetNumberFragment = new NechetNumberFragment();
            ChetNumberFragment     }

        if ( == null) {
            ChetNumberFragment = new ChetNumberFragment();
        }

        showNumberFragment();
    }


    @Override
    public void onNumberClick(int num, @ColorInt int color) {
        showNechetNumberFragment(num, color);
    }

    private void showNechetNumberFragment(int number, @ColorInt int color) {
        NechetNumberFragment.setNumber(number, color);

        if (getSupportFragmentManager().findFragmentByTag(NechetNumberFragment.TAG) != null) {
            return;
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, NechetNumberFragment, NechetNumberFragment.TAG)
                .addToBackStack(NechetNumberFragment.TAG)
                .commit();
    }

    private void showNumbersFragment() {
        if (getSupportFragmentManager().findFragmentByTag(ChetNumberFragment.TAG) != null) {
            return;
        }

        getSupportFragmentManager().beginTransaction()
                .add(R.id.content, ChetNumberFragment, ChetNumberFragment.TAG)
                .commit();
    }

}
