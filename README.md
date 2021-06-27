Heart Attack Prediction

Input Attributes
The training dataset contains 14 attributes. The attributes from 0 to 12 are input to the system and the 13th attribute is the output that ranges from 0 to 4 which is used to train the system. The input to the given system is as follows:

a.Age: The input is given as the age in a number of years of the patient.

b.Sex: For female input value is 0, male input value is 1.

c.Chest Pain Type: 
  i.Value 1- Typical Angina: Typical Angina is the substernal chest pain provoked by physical or emotional stress which was relieved by   rest or nitro-glycerine.
  ii.Value 2- Atypical Angina: Atypical Angina is the chest pain which includes ambiguous chest discomfort and shortness of breath along    with typical angina.
  iii.Value 3- Non-angina Pain: Chest pain with a duration of over 30 mins or less than 5 seconds and can be relive easily.
  iv.Value 4- Asymptomatic: Asymptomatic chest pain does not cause or exhibit the symptoms of the disease.
  
d.Resting Blood Pressure: It is the blood pressure value for a person normally without any vigorous activities. It is measured as 120 mm Hg systolic, which is the pressure when heartbeats and over 80 mm Hg diastolic, which is the pressure when the heart relaxes.

e.Serum Cholesterol in mg/dL: Total serum cholesterol consists of HDL cholesterol also known as good cholesterol, LDL Cholesterol also known as bad cholesterol, and triglycerides. Total serum cholesterol above 200 mg/dL raises the risk of heart disease.

f.Fasting Blood Sugar: It is the level of glucose after fasting for 8 hours. It should be less than 100 mg/dL. The input value should be 1 for FBS greater than 120 mg/dL or value should be 0 for FBS less than 120 mg/dL.

g.Resting Electrocardiograph Result:  Resting electrocardiogram measures the electrical activity of the heart. Value 0 denotes normal, value 1 denotes ST and T wave abnormality, and value 2 denotes probable or definite left ventricular hypertrophy which shows the enlargement or thickening of walls of heart's main pumping chamber.

h.Maximum Heart Rate Achieved: The maximum heart rate of the person is measured while performing rigorous activities like running, biking, etc. The maximum heart rate dangerous for a person depends on their age.

i.Exercise-Induced Angina: A chest discomfort during activity is exercise-induced angina. Value is either 1 or 0 depending on whether a person has exercise-induced angina or not respectively.

j.ST depression induced by exercise relative to rest:  The ST segment lying very low below baseline in electrocardiogram during exercise to the ratio of during rest.

k.The slope of the pick exercise ST segment: It can be observed from electrocardiograph results. 
  i.Value 1-Upsloping
  ii.Value 2- Flat
  iii.Value 3-Downsloping 
  
l.The number of major vessels colored by fluoroscopy: Fluoroscopy is an X-ray movie in which the body part and its motion can be seen clearly.

m.Thal: Thal or Thalassemia is an abnormal production of hemoglobin. 
  i.Value 3-Normal 
  ii.Value 6-Fixed defect
  iii.Value 7-Reversible defect
