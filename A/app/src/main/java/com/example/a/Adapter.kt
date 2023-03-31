package com.example.a
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.a.Adapter.ViewHolder

class Adapter(private val items: ArrayList<EmployeEntity>) :         //creating the Recycler view's Adapter
    RecyclerView.Adapter<Adapter.ViewHolder<Any?>>() {

    var onItemClick: ((EmployeEntity) -> Unit)? = null

    //on click method for editing the particular user it take UserEntity as parameter and return type is Unit
    var onDeleteClick: ((EmployeEntity) -> Unit)? = null

    //On Click's method for deleting the particular user     ''            ''           ''
    private var isEditCancelClicked: Boolean = true


    fun displayCancel() {
        isEditCancelClicked = true
        // Logic is whenever I click the "edit" button in screen it invokes
        // this method and change the variable to true and it should display
        //  the (-) delete image to the user... but it is not working
        //  so I directly put the variable to true and it displays every time
        //  I have to implement this........
        // Log.e("Display Cancel","Display cancel is clicked,,")

    }

    class ViewHolder<RecyclerviewBinding>(binding: RecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {     //creating the View Holder class for the parameter of the
        //main class

        val User = binding.user

        val nametv = binding.tvname
        val emailtv = binding.tvemailid
        val Gendertv = binding.tvgender
        val btechtv = binding.tvbtech
        val Dobtv = binding.tvdob

        //necessary variables in the Recycler views xml file
        val tvDateTime = binding.tvdatetime
        val tvStar1 = binding.star1
        val tvStar2 = binding.star2
        val tvStar3 = binding.star3
        val tvStar4 = binding.star4
        val tvStar5 = binding.star5
        //for rating purpose....

        val cardView = binding.cardview
        val imgCancel = binding.cancel


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<Any?> {
        //overriding the methods
        return ViewHolder(
            Recyclerview1Binding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder<Any?>, position: Int) {

        val context = holder.itemView.context
        val item = items[position]
        //getting the particular item from arrayList of items

        holder.nametv.text = item.name
        holder.emailtv.text = item.Emailid
        holder.Gendertv.text = item.gender
        holder.btechtv.text = item.btech
        holder.Dobtv.text = item.dob
        holder.tvDateTime.text = item.dateTime
        //assigning the users data to the card of the recycler View


        holder.cardView.setOnClickListener {
            onItemClick?.invoke(item)
            //By clicking on item of Rv the Edit page should be opened with his details
            // Log.e("Inside item view","item view is clicked...${item.name}")  // For MY Checking and Confirmation Purpose

        }
        if (isEditCancelClicked)
            holder.imgCancel.visibility = View.VISIBLE
        //Logic need to be implemented but im unable to do it :(  :(
        // My logic is that when the "Edit" is clicked then the cancel image

        else
            holder.imgCancel.visibility = View.GONE
        //should VISIBLE otherwise it should GONE


        holder.imgCancel.setOnClickListener {
            onDeleteClick?.invoke(item)
            //Invoking the lambda method for Deleting the particular User
            //Log.e("Inside Cancel","Delete image is clicked for...${item.name}")
            // For Verification Purpose

        }

    }


}

