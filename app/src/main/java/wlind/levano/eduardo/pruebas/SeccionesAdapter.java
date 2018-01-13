package wlind.levano.eduardo.pruebas;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class SeccionesAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> listaFragments = new ArrayList<>();
    private final List<String> titulos = new ArrayList<>();

    public void addFragment(Fragment fragment, String titulo){
        listaFragments.add(fragment);
        titulos.add(titulo);
    }

    public SeccionesAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titulos.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return listaFragments.get(position);
    }

    @Override
    public int getCount() {
        return listaFragments.size();
    }
}
