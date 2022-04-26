package co.edu.eam.miprimeraapp.modelo

import android.os.Parcel
import android.os.Parcelable

class categoria(var codigo:String?, var nombre:String?, var productos: ArrayList<Producto>):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.createTypedArrayList(CREATOR) as ArrayList<Producto>
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(codigo)
        parcel.writeString(nombre)
        parcel.writeList(productos)
        parcel.writeTypedList(productos)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<categoria> {
        override fun createFromParcel(parcel: Parcel): categoria {
            return categoria(parcel)
        }

        override fun newArray(size: Int): Array<categoria?> {
            return arrayOfNulls(size)
        }
    }
}