package ax.ha.it.fragmentsdemo;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import ax.ha.it.fragmentsdemo.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(getContext(), R.array.categories_spinner, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.categorySpinner.setAdapter(spinnerAdapter);
        AdviceViewModel model = new ViewModelProvider(requireActivity()).get(AdviceViewModel.class);
        if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            binding.button2.setOnClickListener(view -> Navigation.findNavController(view).navigate(R.id.action_secondFragment2_to_firstFragment2));
        }
        binding.addAdviceButton.setOnClickListener(view -> {
            String author = binding.author.getText().toString();
            String category = binding.categorySpinner.getSelectedItem().toString();
            String content = binding.content.getText().toString();
            model.addString(new Advice(author, content, category));
        });
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
