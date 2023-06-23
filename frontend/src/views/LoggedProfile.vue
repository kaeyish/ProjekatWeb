<template>
DOBRO DOSLI UWU OWO
<button type="button" id="logout-b" @click="logOut()">LogOut</button>
  
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
    }
  }


}


</script>

<style></style>