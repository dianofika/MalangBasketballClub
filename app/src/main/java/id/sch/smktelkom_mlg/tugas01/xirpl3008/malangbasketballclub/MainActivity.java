package id.sch.smktelkom_mlg.tugas01.xirpl3008.malangbasketballclub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama;
    EditText etSekolah;
    EditText etNomor;
    EditText etAlamat;
    TextView tvHasil;
    RadioButton rbP, rbL;
    CheckBox cb1, cb2, cb3;
    Spinner spinner;

    Button bOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.etNama);
        etSekolah = (EditText) findViewById(R.id.etSekolah);
        etNomor = (EditText) findViewById(R.id.etNomor);
        etAlamat = (EditText) findViewById(R.id.etAlamat);
        bOK = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.tvHasil);
        rbP = (RadioButton) findViewById(R.id.rbPerempuan);
        rbL = (RadioButton) findViewById(R.id.rbLaki);
        cb1 = (CheckBox) findViewById(R.id.cb1);
        cb2 = (CheckBox) findViewById(R.id.cb2);
        cb3 = (CheckBox) findViewById(R.id.cb3);
        spinner = (Spinner) findViewById(R.id.spinner);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doProses();
                doClick();
                doGo();
                doSpin();

            }
        });
    }

    private void doSpin() {
        tvHasil.setText("\n Posisi Anda adalah " + spinner.getSelectedItem().toString());
    }

    private void doGo() {
        String hasil = "Prestasi yang telah diraih ";
        int startlen = hasil.length();
        if (cb1.isChecked()) hasil += cb1.getText() + "\n";
        if (cb2.isChecked()) hasil += cb2.getText() + "\n";
        if (cb3.isChecked()) hasil += cb3.getText() + "\n";

        if (hasil.length() == startlen) hasil += "Tidak ada pada Pilihan";
        tvHasil.setText(hasil);
    }

    private void doClick() {

        String hasil = null;

        if (rbP.isChecked()) {
            hasil = rbP.getText().toString();
        } else if (rbL.isChecked()) {
            hasil = rbL.getText().toString();
        }

        if (hasil == null) {
            tvHasil.setText("Belum Memilih Status");
        } else {
            tvHasil.setText("\n Jenis Kelamin  : " + hasil);
        }
    }


    private void doProses() {

        if (isValid()) {
            String nama = etNama.getText().toString();
            String sekolah = etSekolah.getText().toString();
            int nomor = Integer.parseInt(etNomor.getText().toString());
            String alamat = etAlamat.getText().toString();
            tvHasil.setText("\n Nama   : " + nama + "\n Sekolah    : " + sekolah + "\n No.Telp     : " + nomor + "\n Alamat    : " + alamat);
        }
    }

    private boolean isValid() {

        boolean valid = true;

        String nama = etNama.getText().toString();
        String sekolah = etSekolah.getText().toString();
        int nomor = Integer.parseInt(etNomor.getText().toString());
        String alamat = etAlamat.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama Belum Diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama Minimal 3 Karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }

        if (sekolah.isEmpty()) {
            etSekolah.setError("Sekolah Belum Diisi");
            valid = false;
        } else {
            etSekolah.setError(null);
        }

        if (alamat.isEmpty()) {
            etAlamat.setError("Alamat Belum Diisi");
            valid = false;
        } else {
            etAlamat.setError(null);
        }

        return valid;
    }
}
