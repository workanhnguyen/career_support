function prev() {
    const filterDOM = document.getElementById("stats-filter");

    if (filterDOM.value === 'year') {
        const fromYearDOM = document.getElementById("yearFrom");
        const toYearDOM = document.getElementById("yearTo");

        fromYearDOM.value = (parseInt(fromYearDOM.value) - 5).toString();
        toYearDOM.value = (parseInt(toYearDOM.value) - 5).toString();
    } else if (filterDOM.value === 'month') {
        const yearForMonthDOM = document.getElementById("wholeYear");

        yearForMonthDOM.value = (parseInt(yearForMonthDOM.value) - 1).toString();
    } else if (filterDOM.value === 'quater') {
        const yearForQuater = document.getElementById("yearForQuater");

        yearForQuater.value = (parseInt(yearForQuater.value) - 1).toString();
    }
}

function next() {
    const filterDOM = document.getElementById("stats-filter");

    if (filterDOM.value === 'year') {
        const fromYearDOM = document.getElementById("yearFrom");
        const toYearDOM = document.getElementById("yearTo");

        fromYearDOM.value = (parseInt(fromYearDOM.value) + 5).toString();
        toYearDOM.value = (parseInt(toYearDOM.value) + 5).toString();
    } else if (filterDOM.value === 'month') {
        const yearForMonthDOM = document.getElementById("wholeYear");

        yearForMonthDOM.value = (parseInt(yearForMonthDOM.value) + 1).toString();
    } else if (filterDOM.value === 'quater') {
        const yearForQuater = document.getElementById("yearForQuater");

        yearForQuater.value = (parseInt(yearForQuater.value) + 1).toString();
    }
}

function changeStatsFilter () {
    const filterDOM = document.getElementById("stats-filter");
    const statsYearPeriodDOM = document.getElementById("stats-year");
    const statsMonthDOM = document.getElementById("stats-month");
    const statsQuaterDOM = document.getElementById("stats-quater");

    filterDOM.addEventListener("change", function () {
        switch (filterDOM.value) {
            case 'year':
                statsYearPeriodDOM.style.display = 'flex';
                statsMonthDOM.style.display = 'none';
                statsQuaterDOM.style.display = 'none';
                break;
            case 'month':
                statsYearPeriodDOM.style.display = 'none';
                statsMonthDOM.style.display = 'flex';
                statsQuaterDOM.style.display = 'none';
                break;
            case 'quater':
                statsYearPeriodDOM.style.display = 'none';
                statsMonthDOM.style.display = 'none';
                statsQuaterDOM.style.display = 'flex';
                break;
            default:
                break;
        }
    })
}

function statistic(jwtToken) {
    const filterDOM = document.getElementById("stats-filter");
    console.log(2);

    if (filterDOM.value === 'year') {
        const fromYearDOM = document.getElementById("yearFrom");
        const toYearDOM = document.getElementById("yearTo");

        console.log(1);

        let barColors = ["red", "green", "blue", "orange", "brown"];

        // Statistic User
        fetch(`/server/api/v1/stats/year/users?from=${fromYearDOM.value}&to=${toYearDOM.value}`, {
            method: 'GET',
            headers: {
                "Authorization": "Bearer " + jwtToken,
                "Content-Type": "application/json"
            }
        })
        .then(response => response.json())
        .then(data => {
            let userChartTitles = [];
            let userChartValues = [];

            for (var i = 0; i < data.length; i++) {
                userChartTitles[i] = data[i].title;
                userChartValues[i] = data[i].value;
            }

            new Chart("userChart", {
                type: "bar",
                data: {
                    labels: userChartTitles,
                    datasets: [{ data: userChartValues, backgroundColor: barColors }],
                },
                options: {
                    legend: { display: false }, title: { display: true, text: `Số lượng người dùng đăng ký từ năm ${fromYearDOM.value} đến năm ${toYearDOM.value}` }
                }
            })
        });

        // Statistic Holland Survey Response
        fetch(`/server/api/v1/stats/year/surveys/holland?from=${fromYearDOM.value}&to=${toYearDOM.value}`, {
            method: 'GET',
            headers: {
                "Authorization": "Bearer " + jwtToken,
                "Content-Type": "application/json"
            }
        })
        .then(response => response.json())
        .then(data => {
            let hollandSurveyChartTitles = [];
            let hollandSurveyChartValues = [];

            for (var i = 0; i < data.length; i++) {
                hollandSurveyChartTitles[i] = data[i].title;
                hollandSurveyChartValues[i] = data[i].value;
            }

            new Chart("hollandSurveyResponseChart", {
                type: "bar",
                data: {
                    labels: hollandSurveyChartTitles,
                    datasets: [{ data: hollandSurveyChartValues, backgroundColor: barColors }],
                },
                options: {
                    legend: { display: false }, title: { display: true, text: `Số lượng thực hiện khảo sát Holland từ năm ${fromYearDOM.value} đến năm ${toYearDOM.value}` }
                }
            })
        });
    }
}

changeStatsFilter();