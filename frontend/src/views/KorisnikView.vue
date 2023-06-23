<template>
<div class="card">
<div class="card-text">
    <div class="portada">
    
        <img src='../assets/old-open-Book-Clip-Art.png'>

    </div>
    <div class="title-total">   
      <div class="title">{{korisnik.uloga}}</div>
      <h2>{{korisnik.ime}} {{korisnik.prezime}}</h2>
      <h6>datum rodjenja nije najfunkcionalniji: {{ korisnik.datumRodjenja }}</h6>
  
  <div class="desc">{{ korisnik.opis }}</div>
  </div>
 </div>
  </div>
  
 

</template>

<script>
export default{
    name: 'KorisnikVIew',   
    data: function() {
        return {
            korisnik: {},
        }
    },
    mounted: function () {
        fetch('http://localhost:9090/api/korisnik/'+ this.$route.params.id)
        .then(response => response.json())
            .then(data => {console.log("Success:", data); this.korisnik = data})
            .catch((error) => {
                console.error("Error:", error);
            });    
    }

}
</script>

<style>
  img {
        max-width:200pt !important;
  }
/* @import url("https://fonts.googleapis.com/css?family=Roboto:400,400i,700");
body {
  font-family: Roboto, sans-serif;
  margin: 0;
  height: 100vh;
  display: grid;
  align-items: center;
  justify-items: center;
  background-image: linear-gradient(to top, #96fbc4 0%, #f9f586 100%);
}
.card {
  background: #fff;
  border-radius: 4px;
  box-shadow: 0px 14px 80px rgba(34, 35, 58, 0.5);
  max-width: 400px;
  display: flex;
  flex-direction: row;
  border-radius: 25px;
  position: relative;
}
.card h2 {
  margin: 0;
  padding: 0 1rem;
}
.card .title {
  padding: 1rem;
  text-align: right;
  color: green;
  font-weight: bold;
  font-size: 12px;
}
.card .desc {
  padding: 0.5rem 1rem;
  font-size: 12px;
}

#img-avatar {
  width: 80px;
  height: 80px;
  position: absolute;
  border-radius: 50%;
  border: 6px solid white;
  top: 15px;
  left: 85px;
}

.title-total {
  padding: 2.5em 1.5em 1.5em 1.5em;
}

path {
  fill: white;
}

.img-portada {
  width: 100%;
}



button {
  border: none;
  background: none;
  float: right;
  font-size: 11px;
  color: #8bc34a;
  cursor: pointer;
  transition:.5s;
} */

</style>