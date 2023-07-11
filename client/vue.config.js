const path = require('path');
const dotenv = require('dotenv');
dotenv.config({ path: path.join(__dirname, '.env') });

const { defineConfig } = require('@vue/cli-service')
module.exports = {
  // devServer: {
  //   proxy: {
  //     '/api': {
  //       target: 'http://localhost:8100',
  //       changeOrigin: true,
  //     }
  //   }
  // },
};