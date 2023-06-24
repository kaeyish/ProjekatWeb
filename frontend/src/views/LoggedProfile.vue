<template>

<button class="btn btn-outline-dark" type="submit" v-on:click.prevent = "redirect()"> IDI NA PROFIL </button>
  
</template>

<script>
export default{
    name: 'LoggedProfile',
    methods: {
    logOut: function(){
//     localStorage.clear()
      fetch("http://localhost:9090/api/logout", {
        method: 'POST',
        credentials: 'include',
        headers: {
          'Content-Type': 'application/json'
        },
      })
    },
    redirect() {
      this.$router.push("/korisnik/"+localStorage.getItem("id"))
    }
  }


}


</script>

<style></style>