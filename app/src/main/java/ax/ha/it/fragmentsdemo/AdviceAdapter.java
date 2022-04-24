package ax.ha.it.fragmentsdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ax.ha.it.fragmentsdemo.databinding.ItemAdviceBinding;


public class AdviceAdapter extends RecyclerView.Adapter<AdviceAdapter.AdviceViewHolder> {
    private List<Advice> dataset;
    // A ViewHolder represents an item view within the RecyclerView
    public static class AdviceViewHolder extends RecyclerView.ViewHolder {
    private final ItemAdviceBinding binding;
        public AdviceViewHolder(@NonNull ItemAdviceBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            // The binding is used in Adapter.onBindViewHolder to access the
            // views in the row (only a single TextView in this example)

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public AdviceAdapter(List<Advice> dataset) {
        this.dataset = dataset;
        notifyDataSetChanged();
    }

    public AdviceAdapter() {}


    public void updateDataset(List<Advice> adviceList) {
        this.dataset = adviceList;
        notifyDataSetChanged();
    }
    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public AdviceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemAdviceBinding binding = ItemAdviceBinding.bind(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_advice, parent, false));
        return new AdviceViewHolder(binding);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(AdviceViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.binding.adviceAuthor.setText(dataset.get(position).author);
        holder.binding.adviceCategory.setText(dataset.get(position).category);
        holder.binding.adviceContent.setText(dataset.get(position).content);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
