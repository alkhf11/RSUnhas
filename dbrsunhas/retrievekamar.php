<?php
    require ("koneksi.php");
    $perintah = "SELECT * FROM kamar";
    $eksekusi = mysqli_query($konek, $perintah);
    $cek = mysqli_affected_rows($konek);

    if($cek>0) {
        $response["kode"]=1;
        $response["pesan"]="Data tersedia";
        $response["data"]=array();

        while($ambil=mysqli_fetch_object($eksekusi)) {
            $Ar["namakamar"]=$ambil->namakamar;
            $Ar["update"]=$ambil->update;
            $Ar["tempat"]=$ambil->tempat;
            $Ar["kosong"]=$ambil->kosong;

            array_push($response["data"], $Ar);
        }

    }    else {
        $response["kode"]=0;
        $response["pesan"]="Data tidak tersedia";
    }
    echo json_encode($response);
    mysqli_close($konek);
    