

<template>
  
  <button class="btn btn-outline-dark" type="submit" v-on:click.prevent = "logout()" >LogOut</button>
  <button class="btn btn-outline-dark" type="submit" v-on:click.prevent = "dodaj()" >DODAJ +</button>

  <nav>
    <!-- <router-link to="/">Home</router-link> | -->
    <router-link to="/index">Index</router-link> |
    <router-link to="/login">LogIn</router-link> |
    <router-link to="/register">Register</router-link>|
    <router-link to="/userProfile">Profil</router-link>   |
    <router-link to="/korisnici">Svi Korisnici</router-link> |
    <router-link to = '/knjige'>Knjige</router-link> |
    <router-link to = '/zanrovi'>Svi zanrovi</router-link> |
    <router-link to = '/recenzije'>Recenzije</router-link> |
    <router-link to = '/pretraga'>Pretraga</router-link> |
    <router-link to="/zahtevi">Zahtevi</router-link>  

  
  </nav>
  <router-view/>

</template>
<script>
 export default{
  methods:{
    logout(){
      localStorage.clear();
      alert("logged out");

      fetch('http://localhost:9090/api/logout',{
        method: 'POST',
        credentials: 'include',
        })
                .then (this.$router.push('/index'))
                .catch((error) => {
                    console.error("Error:", error);
                });    
    },
    dodaj(){
      this.$router.push("/dodavanja")
    }
  }
}

</script>
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  /* float: left; */
  color: #2c3e50;
}

#logout-b{
  float:right;
}

nav a.router-link-exact-active {
  color: #c9b38d;
}
</style>
