function gradingStudents(grades) {
  // Write your code here
  for (let i = 0; i < grades.length; i++) {
    if (grades[i] > 37) {
      let nextFive = Math.ceil(grades[i] / 5) * 5;
      let difference = nextFive - grades[i];
      if (difference < 3) {
        grades[i] = nextFive;
      }
    }
  }
  return grades;
}
