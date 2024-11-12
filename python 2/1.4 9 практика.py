file_name = "stix.txt"

vowels = "аеёиоуыэюяАЕЁИОУЫЭЮЯ"

try:
    with open(file_name, "r", encoding="utf-8") as file:
        content = file.read()
        print("Содержимое файла:")
        print(content)

    words = content.split()
    vowel_count = 0
    consonant_count = 0

    for word in words:
        first_letter = word[0].lower()
        if first_letter in vowels:
            vowel_count += 1
        elif first_letter.isalpha(): 
            consonant_count += 1

    if vowel_count > consonant_count:
        print("Слов на гласную букву больше.")
    elif consonant_count > vowel_count:
        print("Слов на согласную букву больше.")
    else:
        print("Количество слов на гласную и согласную буквы одинаковое.")

except FileNotFoundError:
    print("Файл не найден. Убедитесь, что файл stix.txt существует.")
except Exception as e:
    print(f"Произошла ошибка: {e}")
