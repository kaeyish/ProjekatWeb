

<template>
  
  <nav>
    <!-- <router-link to="/">Home</router-link> | -->
    <router-link to="/index">Index</router-link> |
    <router-link to="/login">LogIn</router-link> |
    <router-link to="/register">Register</router-link>   
  </nav>
  <router-view/>

</template>

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
