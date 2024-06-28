# import the library for data analysis 
import pandas as pd

# Load the CSV file into a DataFrame
filePath = 'D:\\Python projects\\Employees.csv'
df = pd.read_csv(filePath)


# 1. Remove any duplicates
# inplace meaning that the operation is performed on the existing DataFrame without returning a new DataFrame
df.drop_duplicates(inplace=True)

# 2. Remove any decimal places in the Age column
df['Age'] = df['Age'].astype(int)

# 3. Convert the USD salary to EGP (assuming an exchange rate of 1 USD = 47 EGP)
exchange_rate = 47
df['Salary(EGP)'] = df['Salary(USD)'] * exchange_rate

# 4. Print stats
average_age = df['Age'].mean()
median_salary_usd = df['Salary(USD)'].median()
gender_ratio = df['Gender'].value_counts(normalize=True)

# Print stats
print(f"Average Age: {average_age}")
print(f"Median Salary (USD): {median_salary_usd}")
print(f"Gender Ratio (Male:Female): {gender_ratio.get('M', 0)}:{gender_ratio.get('F', 0)}")

# 5. Write the updated DataFrame to a new CSV file
output_file_path = 'D:\\Python projects\\Updated_Employees.csv'
df.to_csv(output_file_path, index=False)

print(f"Updated data has been saved to {output_file_path}")
