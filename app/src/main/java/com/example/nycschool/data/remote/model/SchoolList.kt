package com.example.nycschool.data.remote.model

data class SchoolList(

    var dbn: String,


    var school_name: String,


    var boro: String,


    var overview_paragraph: String,


    var school_10th_seats: String,


    var academicopportunities1: String,


    var academicopportunities2: String,

    var ell_programs: String,


    var neighborhood: String,


    var building_code: String,


    var location: String,


    var phone_number: String,


    var fax_number: String,


    var school_email: String,


    var website: String,


    var subway: String,


    var bus: String,


    var grades2018: String,


    var finalgrades: String,


    var total_students: String,


    var extracurricular_activities: String,


    var school_sports: String,


    var attendance_rate: String,


    var pct_stu_enough_variety: String,


    var pct_stu_safe: String,


    var school_accessibility_description: String,


    var directions1: String,


    var requirement1_1: String,


    var requirement2_1: String,


    var requirement3_1: String,


    var requirement4_1: String,


    var requirement5_1: String,


    var offer_rate1: String,


    var program1: String,


    var code1: String,


    var interest1: String,


    var method1: String,


    var seats9ge1: String,


    var grade9gefilledflag1: String,


    var grade9geapplicants1: String,


    var seats9swd1: String,


    var grade9swdfilledflag1: String,


    var grade9swdapplicants1: String,


    var seats101: String,


    var admissionspriority11: String,


    var admissionspriority21: String,


    var admissionspriority31: String,


    var grade9geapplicantsperseat1: String,


    var grade9swdapplicantsperseat1: String,

    var primary_address_line_1: String,


    var city: String,


    var zip: String,


    var state_code: String,


    var latitude: String,


    var longitude: String,


    var community_board: String,

    var council_district: String,


    var census_tract: String,


    var bin: String,


    var bbl: String,


    var nta: String,


    var borough: String
) {
    override fun toString(): String {
        return "SchoolList(dbn=$dbn, school_name=$school_name, boro=$boro, overview_paragraph=$overview_paragraph, school_10th_seats=$school_10th_seats, academicopportunities1=$academicopportunities1, academicopportunities2=$academicopportunities2, ell_programs=$ell_programs, neighborhood=$neighborhood, building_code=$building_code, location=$location, phone_number=$phone_number, fax_number=$fax_number, school_email=$school_email, website=$website, subway=$subway, bus=$bus, grades2018=$grades2018, finalgrades=$finalgrades, total_students=$total_students, extracurricular_activities=$extracurricular_activities, school_sports=$school_sports, attendance_rate=$attendance_rate, pct_stu_enough_variety=$pct_stu_enough_variety, pct_stu_safe=$pct_stu_safe, school_accessibility_description=$school_accessibility_description, directions1=$directions1, requirement1_1=$requirement1_1, requirement2_1=$requirement2_1, requirement3_1=$requirement3_1, requirement4_1=$requirement4_1, requirement5_1=$requirement5_1, offer_rate1=$offer_rate1, program1=$program1, code1=$code1, interest1=$interest1, method1=$method1, seats9ge1=$seats9ge1, grade9gefilledflag1=$grade9gefilledflag1, grade9geapplicants1=$grade9geapplicants1, seats9swd1=$seats9swd1, grade9swdfilledflag1=$grade9swdfilledflag1, grade9swdapplicants1=$grade9swdapplicants1, seats101=$seats101, admissionspriority11=$admissionspriority11, admissionspriority21=$admissionspriority21, admissionspriority31=$admissionspriority31, grade9geapplicantsperseat1=$grade9geapplicantsperseat1, grade9swdapplicantsperseat1=$grade9swdapplicantsperseat1, primary_address_line_1=$primary_address_line_1, city=$city, zip=$zip, state_code=$state_code, latitude=$latitude, longitude=$longitude, community_board=$community_board, council_district=$council_district, census_tract=$census_tract, bin=$bin, bbl=$bbl, nta=$nta, borough=$borough)"
    }
}