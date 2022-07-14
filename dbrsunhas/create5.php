<?php
    require ("koneksi.php");

    $response = array();


    if ($_SERVER['REQUEST_METHOD']=='POST')
    {
        $nama = $_POST["nama"];
        $lahir = $_POST["lahir"];
        $notelepon = $_POST["notelepon"];
        $kunjungan = $_POST["kunjungan"];
        $rekmed = date("mdhis",strtotime('now'));

        $perintah = "INSERT INTO politht (nama, lahir, notelepon, kunjungan, rekmed) VALUES ('$nama', '$lahir', '$notelepon', '$kunjungan', '$rekmed')" ;
        $eksekusi = mysqli_query($konek, $perintah);
        $cek = mysqli_affected_rows($konek);

        if($cek>0) {
            $response["kode"]=1;
            $response["pesan"]="Simpan Data Berhasil";
        }
        else
        {
            $response["kode"]=0;
            $response["pesan"]="Simpan Data Gagal";
        }
    }
    else {
        $response["kode"]=0;
        $response["pesan"]="Tidak Ada Post Data";
    }

    echo json_encode($response);
    mysqli_close($konek);