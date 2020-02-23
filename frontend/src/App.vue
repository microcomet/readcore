<template>
  <div id="app">
    <!-- <img src="./assets/logo.png"> -->
    <router-view/>
    <bottom></bottom>
  </div>
</template>

<script>
import Bottom from './components/Footer.vue'
export default {
  name: 'App',
  components: {
    bottom: Bottom
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
p {
  text-indent: 2em
}
</style>
