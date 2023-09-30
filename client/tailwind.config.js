/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        'primary': '#1876D2'
      },
      backgroundImage: {
        'main-intro': "url(https://res.cloudinary.com/dduhlnft3/image/upload/v1696045750/frontend/set-bright-school-stationery-orange-wall_y8ozka.jpg)",
      }
    },
  },
  plugins: [],
}