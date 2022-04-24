package ax.ha.it.fragmentsdemo;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import ax.ha.it.fragmentsdemo.databinding.FragmentFirstBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private AdviceAdapter recyclerViewAdapter;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            binding.button1.setOnClickListener(view -> Navigation.findNavController(view).navigate(R.id.action_firstFragment2_to_secondFragment2));
        }
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(getContext(), R.array.categories_spinner, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        recyclerViewAdapter = new AdviceAdapter();

        AdviceViewModel model = new ViewModelProvider(requireActivity()).get(AdviceViewModel.class);
        binding.categorySpinner.setAdapter(spinnerAdapter);
        binding.categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onItemSelected(AdapterView adapterView, View view, int i, long l) {
                model.getAdvices().observe(getViewLifecycleOwner(), Observer -> {
                    List<Advice> filteredList = Observer.stream().filter(p -> p.category.equals(binding.categorySpinner.getSelectedItem().toString())).collect(Collectors.toList());
                    recyclerViewAdapter.updateDataset(filteredList);
                });


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        binding.myRecyclerView.setAdapter(recyclerViewAdapter);
        binding.myRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        model.getAdvices().observe(getViewLifecycleOwner(), Observer -> {
            recyclerViewAdapter.updateDataset(Observer);

        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        recyclerViewAdapter = null;
    }

}
