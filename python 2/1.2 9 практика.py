file_name = "numbers.txt"

try:
    with open(file_name, "r") as file:
        numbers = [float(line.strip()) for line in file]
    
    total_sum = sum(numbers)
    maximum = max(numbers)

    with open(file_name, "a") as file:
        file.write(f"{total_sum}\n")
        file.write(f"{maximum}\n")

    print(f"Сумма чисел ({total_sum}) и максимум ({maximum}) добавлены в файл.")
    
except FileNotFoundError:
    print("Файл не найден. Убедитесь, что numbers.txt существует.")
except ValueError:
    print("Ошибка при чтении файла. Убедитесь, что файл содержит только числа.")
