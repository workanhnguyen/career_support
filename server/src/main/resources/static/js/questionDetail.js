function onSelectHollandChange() {
    const selectElement = document.querySelector("#holland-field");
    const hiddenInputElement = document.querySelector("#selected-holland");

    selectElement.addEventListener("change", function() {
        hiddenInputElement.value = selectElement.value;
        console.log(selectElement.value);
    });
}

onSelectHollandChange();