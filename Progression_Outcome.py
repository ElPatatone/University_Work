# program to evaluate the progression outcome of various students according to a specified grading criteria.

#The criteria was:
# 120 credits for passed - Progress
# 100 credits for passed - Progress (module trailer)
# 80 or less credits for passed - Module retriever
# 80 or more credits for failed - progress



#verifying that an input is valid 
def input_valid_number(x):
    while True:
        n = input(f'Please enter your credits at {x}: ')
        if n.isdigit():
            n = int(n)
            credit = [0,20,40,60,80,100,120]
            if n in credit:
                return n
            else:
                print('Out of range.')
        else:
            print('Integer required')


            
outcome_list = []
input_outcome_list = []
input_credit = []


#function to store the input data into lists in order to retrieve the data later on to produce a horizontal histogram.
def store_input_data(x):
    outcome_list.append(x)
    input_outcome_list.append(x)
    input_credit.append(all_outcomes)


#a very simple if and elif statements to check the module scores and print out the correct progession outcome
def evaluate_progression():
    if passed_credits == 120:
        print('Progress\n')
        store_input_data('Progress')
    elif passed_credits == 100:
        print('Progress (module trailer)\n')
        store_input_data('Progress (module trailer)')
    elif passed_credits in [0, 20, 40, 60, 80]:
        if failed_credits in [80, 100, 120]:
            print('Exclude\n')
            store_input_data('Exclude')
    else:
        print('Module retriever\n' )
        store_input_data('Module retriever')


#program to give a more visual representation of the students outcome in the form of a horizontal histogram
#it retrieves the data stored in the lists I made and will produce the histogram to represent them.
def Horizontal_Histogram():
    print('-' * 60)
    print('Horizontal Histogram')
    count1 = outcome_list.count('Progress')
    count2 = outcome_list.count('Progress (module trailer)')
    count3 = outcome_list.count('Module retriever')
    count4 = outcome_list.count('Exclude')
    print('Progress:', count1, ' :', ('*' * count1))
    print('Trailer:', count2, ' :', ('*' * count2))
    print('Retriever:', count3, ' :', ('*' * count3))
    print('Excluded:', count4, ' :', ('*' * count4),'\n')
    total_of_outcomes = sum([count1, count2, count3, count4])
    print(total_of_outcomes, 'outcomes in total')
    print('-' * 60)


    

def input_progression_data():
    for i in range(len(input_outcome_list)):
        global outcome_index
        global credit_index
        outcome_index = input_outcome_list[i]
        credit_index = input_credit[i]
        print(outcome_index, '-', credit_index)
        text_file()


#this will write the input data into a text file
def text_file():
    repr(outcome_index)
    repr(credit_index)
    with open('Hasanur Rahman Mohammad-17809416.txt', 'a') as f:
        f.write(outcome_index + '- ' + str(credit_index) + '\n')


#the whole program is run inside these two while true statements
#if the inpput data passes through the validation functions the program will then move on to evaluate a progression outcome for the data given.
#then you are given the option to either input data for more students or quit the program. Once the program is quit the horizonatl histogram will be printed and the data will be written into a text file.
while True:
    while True:

        passed_credits = input_valid_number('passed')
        defered_credits = input_valid_number('defered')
        failed_credits = input_valid_number('failed')
        all_outcomes = passed_credits, defered_credits, failed_credits
       
        if sum([passed_credits, defered_credits, failed_credits]) == 120:
            break
        print('Total incorrect\n')
    
    evaluate_progression()

    x = input("Would you like to enter another set of data?\nEnter 'y' to continue or 'q' to quit and view results: ")
    print()
    if x == 'y':
        continue
    elif x == 'q':
        Horizontal_Histogram()
        print()
        input_progression_data()
        print('-' * 60)
        with open('Hasanur Rahman Mohammad-17809416.txt', 'r') as f:
            f_contents = f.read()
            print(f_contents)
        break
