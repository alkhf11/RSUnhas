<?php
    require ("koneksi.php");
    $perintah = "SELECT * FROM poliobgin";
    $eksekusi = mysqli_query($konek, $perintah);
    $cek = mysqli_affected_rows($konek);

    if($cek>0) {
        $response["kode1"]=1;
        $response["pesan"]="Data tersedia";
        $response["data"]=array();

        while($ambil=mysqli_fetch_object($eksekusi)) {
            $Ar["noantri"]=$ambil->noantri;
            $Ar["nama"]=$ambil->nama;
            $Ar["lahir"]=$ambil->lahir;
            $Ar["notelepon"]=$ambil->notelepon;
            $Ar["kunjungan"]=$ambil->kunjungan;
            $Ar["rekmed"]=$ambil->rekmed;
            $Ar["poli"]=$ambil->poli;

            array_push($response["data"], $Ar);
        }

    }    else {
        $response["kode1"]=0;
        $response["pesan"]="Data tidak tersedia";
    }
    echo json_encode($response);
    mysqli_close($konek);
    